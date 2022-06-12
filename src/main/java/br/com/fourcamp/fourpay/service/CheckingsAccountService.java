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
		List<CheckingsAccount> accountList = findAll();
		
		for (CheckingsAccount item : accountList) {
			if(item.getClient().getId().equals(checkingsAccount.getClient().getId())) {
				return null;
			}
		}
		
		return checkingsAccountRepository.save(checkingsAccount);
	}

	public CheckingsAccount updateCheckingsAccount(CheckingsAccount checkingsAccount) {
		return checkingsAccountRepository.save(checkingsAccount);
	}

}
