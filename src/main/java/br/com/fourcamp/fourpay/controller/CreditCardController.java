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

import br.com.fourcamp.fourpay.dto.CreditCardDTO;
import br.com.fourcamp.fourpay.model.CreditCard;

@RestController
@RequestMapping("/card/credit")
public class CreditCardController {
	@Autowired
	CreditCardService creditCardService;
	
	@GetMapping
	public List<CreditCard> getAllCards() {
		return creditCardService.findAll();
	}
	
	@PostMapping
	public CreditCard createCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		return creditCardService.save(creditCard);
	}
	
	@PutMapping
	public CreditCard updateCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		return creditCardService.updateCard(creditCard);
	}

}
