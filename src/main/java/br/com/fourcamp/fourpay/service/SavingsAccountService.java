package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.SavingsAccount;
import br.com.fourcamp.fourpay.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {

	@Autowired
	SavingsAccountRepository savingsAccountRepository;
	
	public List<SavingsAccount> findAll() {
		return savingsAccountRepository.findAll();
	}

	public SavingsAccount save(SavingsAccount savingsAccount) {
		return savingsAccountRepository.save(savingsAccount);
	}

	public SavingsAccount updateSavingsAccount(SavingsAccount savingsAccount) {
		return savingsAccountRepository.save(savingsAccount);
	}

}
