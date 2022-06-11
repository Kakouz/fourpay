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

import br.com.fourcamp.fourpay.dto.CreditCardDTO;
import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.service.CreditCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/card/credit")
@Api(value="API REST Credit Card")
@CrossOrigin(origins = "*")
public class CreditCardController {
	@Autowired
	CreditCardService creditCardService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os cartões de credito")
	public List<CreditCard> getAllCards() {
		return creditCardService.findAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria um cartão de credito")
	public CreditCard createCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		return creditCardService.save(creditCard);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um cartão de credito")
	public CreditCard updateCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		return creditCardService.updateCard(creditCard);
	}

}
