package br.com.fourcamp.fourpay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.enums.TransactionType;
import br.com.fourcamp.fourpay.interfaces.TransactionInterface;
import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.model.DebitCard;
import br.com.fourcamp.fourpay.model.SavingsAccount;
import br.com.fourcamp.fourpay.model.Transaction;
import br.com.fourcamp.fourpay.repository.TransactionRepository;

@Service
public class TransactionService implements TransactionInterface {

	public static final Double CREDIT_CARD_TAX = 2.99;

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	SavingsAccountService savingsAccountService;
	@Autowired
	CheckingsAccountService checkingsAccountService;
	@Autowired
	CreditCardService creditCardService;
	@Autowired
	DebitCardService debitCardService;

	@Override
	public boolean sendMoney(Integer payerAccountId, Integer receiverAccountId, Double value,
			TransactionType transactionType) {
		SavingsAccount payerSavingsAcc = savingsAccountService.getAccountById(payerAccountId);
		SavingsAccount receiverSavingsAcc = savingsAccountService.getAccountById(receiverAccountId);
		CheckingsAccount payerCheckingsAcc = checkingsAccountService.getAccountById(payerAccountId);
		CheckingsAccount receiverCheckingsAcc = checkingsAccountService.getAccountById(receiverAccountId);

		if (transactionType.equals(TransactionType.CREDITCARD)) {
			if (payerSavingsAcc != null) {
				CreditCard cc = creditCardService.getCardById(payerSavingsAcc.getId());
				if ((cc.getCreditLimit() - value - CREDIT_CARD_TAX) > 0) {
					cc.setCreditLimit(cc.getCreditLimit() - value - CREDIT_CARD_TAX);
				} else {
					return false;
				}
			} else if (payerCheckingsAcc != null) {
				CreditCard cc = creditCardService.getCardById(payerCheckingsAcc.getId());
				if ((cc.getCreditLimit() - value - CREDIT_CARD_TAX) > 0) {
					cc.setCreditLimit(cc.getCreditLimit() - value - CREDIT_CARD_TAX);
				} else {
					return false;
				}
			}
		}

		if (transactionType.equals(TransactionType.DEBITCARD)) {
			if (payerSavingsAcc != null) {
				DebitCard dc = debitCardService.getCardById(payerSavingsAcc.getId());
				if ((dc.getTransactionLimit() - value) > 0) {
					dc.setTransactionLimit(dc.getTransactionLimit() - value);
				} else {
					return false;
				}
			} else if (payerCheckingsAcc != null) {
				DebitCard dc = debitCardService.getCardById(payerCheckingsAcc.getId());
				if ((dc.getTransactionLimit() - value) > 0) {
					dc.setTransactionLimit(dc.getTransactionLimit() - value);
				} else {
					return false;
				}
			} 
		}

		if (payerSavingsAcc != null) {
			if (receiverSavingsAcc != null) {
				if (payerSavingsAcc.getBalance() - value >= 0) {
					payerSavingsAcc.setBalance(payerSavingsAcc.getBalance() - value);
					receiverSavingsAcc.setBalance(receiverSavingsAcc.getBalance() + value);
					savingsAccountService.save(payerSavingsAcc);
					savingsAccountService.save(receiverSavingsAcc);
					return true;
				}

			} else if (receiverCheckingsAcc != null) {
				if (payerSavingsAcc.getBalance() - value >= 0) {
					payerSavingsAcc.setBalance(payerSavingsAcc.getBalance() - value);
					receiverCheckingsAcc.setBalance(receiverCheckingsAcc.getBalance() + value);
					savingsAccountService.save(payerSavingsAcc);
					checkingsAccountService.save(receiverCheckingsAcc);
					return true;
				}
			}

		}
		if (payerCheckingsAcc.getBalance() - value >= 0) {
			if (receiverSavingsAcc != null) {
				if (payerCheckingsAcc.getBalance() - value >= 0) {
					payerCheckingsAcc.setBalance(payerCheckingsAcc.getBalance() - value);
					receiverSavingsAcc.setBalance(receiverSavingsAcc.getBalance() + value);
					checkingsAccountService.save(payerCheckingsAcc);
					savingsAccountService.save(receiverSavingsAcc);
					return true;
				} else if (receiverCheckingsAcc != null) {
					if (payerCheckingsAcc.getBalance() - value >= 0) {
						payerCheckingsAcc.setBalance(payerCheckingsAcc.getBalance() - value);
						receiverCheckingsAcc.setBalance(receiverCheckingsAcc.getBalance() + value);
						checkingsAccountService.save(payerCheckingsAcc);
						checkingsAccountService.save(receiverCheckingsAcc);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean discountRates(Integer accountId) {
		// TODO Auto-generated method stub

		return false;
	}

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	public Transaction save(Transaction transaction) {
		if (sendMoney(transaction.getPayerAccountId(), transaction.getReceiverAccountId(), transaction.getValue(),
				transaction.getTransactionType())) {
			return transactionRepository.save(transaction);
		}
		return null;
	}

	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}
