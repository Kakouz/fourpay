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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/account/savings")
@Tag(name = "API REST Savings Account")
@CrossOrigin(origins = "*")
public class SavingsAccountController {

	@Autowired
	SavingsAccountService savingsAccountService;
	@Autowired
	ClientController clientController;

	@GetMapping
	@Operation(summary = "Retorna todas as contas poupança")
	public List<SavingsAccount> getSavingsAccount() {
		return savingsAccountService.findAll();
	}

	@PostMapping
	@Operation(summary = "Cria uma nova conta poupança")
	public SavingsAccount createSavingsAccount(@RequestBody SavingsAccountDTO savingsAccountDto) {
		SavingsAccount savingsAccount = new SavingsAccount();
		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
		savingsAccount.setClient(clientController.getClientById(savingsAccountDto.getClientId()));
		if (savingsAccount.getClient() == null) {
			return null;
		}
		savingsAccount.setNumber(savingsAccount.getClient().getId() + 2000);
		return savingsAccountService.save(savingsAccount);
	}

//	@PutMapping
//	@Operation(summary = "Atualiza uma conta poupança")
//	public SavingsAccount updateSavingsAccount(@RequestBody SavingsAccountDTO savingsAccountDto) {
//		SavingsAccount savingsAccount = new SavingsAccount();
//		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
//		return savingsAccountService.updateSavingsAccount(savingsAccount);
//	}
}
