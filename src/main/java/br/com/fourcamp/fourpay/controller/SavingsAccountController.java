package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.SavingsAccountDTO;
import br.com.fourcamp.fourpay.model.SavingsAccount;
import br.com.fourcamp.fourpay.service.SavingsAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account/savings")
@Api(value="API REST Savings Account")
@CrossOrigin(origins = "*")
public class SavingsAccountController {

	@Autowired
	SavingsAccountService savingsAccountService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todas as contas poupança")
	public List<SavingsAccount> getSavingsAccount() {
		return savingsAccountService.findAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria uma nova conta poupança")
	public SavingsAccount createSavingsAccount(@RequestBody SavingsAccountDTO savingsAccountDto) {
		SavingsAccount savingsAccount = new SavingsAccount();
		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
		return savingsAccountService.save(savingsAccount);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza uma conta poupança")
	public SavingsAccount updateSavingsAccount(@RequestBody SavingsAccountDTO savingsAccountDto) {
		SavingsAccount savingsAccount = new SavingsAccount();
		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
		return savingsAccountService.updateSavingsAccount(savingsAccount);
	}
}
