package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.repository.CheckingsAccountRepository;

@Service
public class CheckingsAccountService {

	@Autowired
	CheckingsAccountRepository checkingsAccountRepository;
	
	public List<CheckingsAccount> findAll() {
		return checkingsAccountRepository.findAll();
	}

	public CheckingsAccount save(CheckingsAccount checkingsAccount) {
		return checkingsAccountRepository.save(checkingsAccount);
	}

	public CheckingsAccount updateCheckingsAccount(CheckingsAccount checkingsAccount) {
		return checkingsAccountRepository.save(checkingsAccount);
	}

}
