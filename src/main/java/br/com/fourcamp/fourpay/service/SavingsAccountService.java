package br.com.fourcamp.fourpay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.SavingsAccount;
import br.com.fourcamp.fourpay.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
	public static final Double YIELD_RATE = 1.00; // 1% de taxa de juros no Mês

	@Autowired
	SavingsAccountRepository savingsAccountRepository;

	public List<SavingsAccount> findAll() {
		return savingsAccountRepository.findAll();
	}

	public SavingsAccount save(SavingsAccount savingsAccount) {
		List<SavingsAccount> accountList = findAll();

		for (SavingsAccount item : accountList) {
			if (item.getClient().getId().equals(savingsAccount.getClient().getId())) {
				return null;
			}
		}
		savingsAccount.setYieldRate(YIELD_RATE);
		return savingsAccountRepository.save(savingsAccount);
	}

	public SavingsAccount updateSavingsAccount(SavingsAccount savingsAccount) {
		savingsAccount.setYieldRate(YIELD_RATE);
		return savingsAccountRepository.save(savingsAccount);
	}

	public SavingsAccount getAccountById(Integer payerAccountId) {
		List<SavingsAccount> accountList = findAll();

		for (SavingsAccount item : accountList) {
			if (item.getId().equals(payerAccountId)) {
				return item;
			}
		}
		return null;
	}
}
