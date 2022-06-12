package br.com.fourcamp.fourpay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.repository.CheckingsAccountRepository;

@Service
public class CheckingsAccountService {
	private static final Double MAINTENANCE_RATE = 1.00; // 1% de taxa de manutenção

	@Autowired
	CheckingsAccountRepository checkingsAccountRepository;

	public List<CheckingsAccount> findAll() {
		return checkingsAccountRepository.findAll();
	}

	public CheckingsAccount save(CheckingsAccount checkingsAccount) {
		List<CheckingsAccount> accountList = findAll();

		for (CheckingsAccount item : accountList) {
			if (item.getClient().getId().equals(checkingsAccount.getClient().getId())) {
				return null;
			}
		}
		checkingsAccount.setMaintenanceRate(MAINTENANCE_RATE);
		return checkingsAccountRepository.save(checkingsAccount);
	}

	public CheckingsAccount updateCheckingsAccount(CheckingsAccount checkingsAccount) {
		checkingsAccount.setMaintenanceRate(MAINTENANCE_RATE);
		return checkingsAccountRepository.save(checkingsAccount);
	}

	public CheckingsAccount getAccountById(Integer payerAccountId) {
		List<CheckingsAccount> accountList = findAll();
		for (CheckingsAccount item : accountList) {
			if (item.getId().equals(payerAccountId)) {
				return item;
			}
		}
		return null;

	}

}
