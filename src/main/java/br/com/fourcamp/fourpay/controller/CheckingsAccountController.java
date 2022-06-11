package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.CheckingsAccountDTO;
import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.service.CheckingsAccountService;

@RestController
@RequestMapping("/account/checkings")
public class CheckingsAccountController {

	@Autowired
	CheckingsAccountService checkingsAccountService;
	
	@GetMapping
	public List<CheckingsAccount> getCheckingsAccount() {
		return checkingsAccountService.findAll();
	}
	
	@PostMapping
	public CheckingsAccount createCheckingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
		CheckingsAccount checkingsAccount = new CheckingsAccount();
		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
		return checkingsAccountService.save(checkingsAccount);
	}
	
	@PutMapping
	public CheckingsAccount updateSavingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
		CheckingsAccount checkingsAccount = new CheckingsAccount();
		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
		return checkingsAccountService.updateCheckingsAccount(checkingsAccount);
	}
}
