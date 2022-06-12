package br.com.fourcamp.fourpay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.interfaces.TransactionInterface;
import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.model.SavingsAccount;
import br.com.fourcamp.fourpay.model.Transaction;
import br.com.fourcamp.fourpay.repository.TransactionRepository;

@Service
public class TransactionService implements TransactionInterface {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	SavingsAccountService savingsAccountService;
	@Autowired
	CheckingsAccountService checkingsAccountService;

	@Override
	public boolean sendMoney(Integer payerAccountId, Integer receiverAccountId, Double value) {
		SavingsAccount payerSavingsAcc = savingsAccountService.getAccountById(payerAccountId);
		SavingsAccount receiverSavingsAcc = savingsAccountService.getAccountById(receiverAccountId);
		CheckingsAccount payerCheckingsAcc = checkingsAccountService.getAccountById(payerAccountId);
		CheckingsAccount receiverCheckingsAcc = checkingsAccountService.getAccountById(receiverAccountId);

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
		if (sendMoney(transaction.getPayerAccountId(), transaction.getReceiverAccountId(), transaction.getValue())) {
			return transactionRepository.save(transaction);
		}
		return null;
	}

	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}
