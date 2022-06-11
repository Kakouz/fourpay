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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account/checkings")
@Api(value="API REST Checkings Account")
@CrossOrigin(origins = "*")
public class CheckingsAccountController {

	@Autowired
	CheckingsAccountService checkingsAccountService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos as contas correntes")
	public List<CheckingsAccount> getCheckingsAccount() {
		return checkingsAccountService.findAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria uma nova conta corrente")
	public CheckingsAccount createCheckingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
		CheckingsAccount checkingsAccount = new CheckingsAccount();
		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
		return checkingsAccountService.save(checkingsAccount);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza uma conta corrente")
	public CheckingsAccount updateSavingsAccount(@RequestBody CheckingsAccountDTO checkingsAccountDTO) {
		CheckingsAccount checkingsAccount = new CheckingsAccount();
		BeanUtils.copyProperties(checkingsAccountDTO, checkingsAccount);
		return checkingsAccountService.updateCheckingsAccount(checkingsAccount);
	}
}
