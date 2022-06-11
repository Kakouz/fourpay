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

import br.com.fourcamp.fourpay.model.DebitCard;
import br.com.fourcamp.fourpay.service.DebitCardService;

@RestController
@RequestMapping("/card/debit")
public class DebitCardController {
	@Autowired
	DebitCardService debitCardService;
	
	@GetMapping
	public List<DebitCard> getAllCards() {
		return debitCardService.findAll();
	}
	
	@PostMapping
	public DebitCard createDebitCard(@RequestBody DebitCard DebitCardDto) {
		DebitCard debitCard = new DebitCard();
		BeanUtils.copyProperties(DebitCardDto, debitCard);
		return debitCardService.save(debitCard);
	}
	
	@PutMapping
	public DebitCard updateDebitCard(@RequestBody DebitCard DebitCardDto) {
		DebitCard debitCard = new DebitCard();
		BeanUtils.copyProperties(DebitCardDto, debitCard);
		return debitCardService.updateCard(debitCard);
	}

}
