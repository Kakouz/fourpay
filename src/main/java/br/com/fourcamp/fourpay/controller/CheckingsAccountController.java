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

import br.com.fourcamp.fourpay.dto.CheckingsAccountDTO;
import br.com.fourcamp.fourpay.model.CheckingsAccount;
import br.com.fourcamp.fourpay.service.CheckingsAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/account/checkings")
@Tag(name="API REST Checkings Account")
@CrossOrigin(origins = "*")
public class CheckingsAccountController {

	@Autowired
	CheckingsAccountService checkingsAccountService;
	@Autowired
	ClientController clientController;
	
	@GetMapping
	@Operation(summary = "Retorna todos as contas correntes")
	public List<CheckingsAccount> getCheckingsAccount() {
		return checkingsAccountService.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Cria uma nova conta corrente")
	public CheckingsAccount createCheckingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
		CheckingsAccount checkingsAccount = new CheckingsAccount();
		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
		checkingsAccount.setClient(clientController.getClientById(checkingsAccountDTO.getClientId()));
		if(checkingsAccount.getClient() == null) {
			return null;
		}		
		checkingsAccount.setNumber(checkingsAccount.getClient().getId() + 1000);
		return checkingsAccountService.save(checkingsAccount);
	}
	
//	@PutMapping
//	@Operation(summary = "Atualiza uma conta corrente")
//	public CheckingsAccount updateSavingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
//		CheckingsAccount checkingsAccount = new CheckingsAccount();
//		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
//		return checkingsAccountService.updateCheckingsAccount(checkingsAccount);
//	}
}
