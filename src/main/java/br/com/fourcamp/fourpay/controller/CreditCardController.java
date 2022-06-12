package br.com.fourcamp.fourpay.controller;

import java.util.List;
import java.util.Random;

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
import br.com.fourcamp.fourpay.enums.ClientType;
import br.com.fourcamp.fourpay.model.Account;
import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.service.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/card/credit")
@Tag(name = "API REST Credit Card")
@CrossOrigin(origins = "*")
public class CreditCardController {
	@Autowired
	CreditCardService creditCardService;
	@Autowired
	CheckingsAccountController checkingsAccountController;
	@Autowired
	SavingsAccountController savingsAccountController;

	@GetMapping
	@Operation(summary = "Retorna todos os cartões de credito")
	public List<CreditCard> getAllCards() {
		return creditCardService.findAll();
	}

	@PostMapping
	@Operation(summary = "Cria um cartão de credito")
	public CreditCard createCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		creditCard.setAccount(checkingsAccountController.getAccountById(creditCardDto.getAccountId()));
		if (creditCard.getAccount() == null) {
			creditCard.setAccount(savingsAccountController.getAccountById(creditCardDto.getAccountId()));
			if (creditCard.getAccount() == null) {
				return null;
			}
		}
		creditCard.setFlag("MASTERCARD");
		creditCard.setIsActive(true);
		creditCard.setCreditLimit(determineCreditLimit(creditCard.getAccount()));
		Random rand = new Random();
		Long accumulator = (long) (1 + rand.nextInt(9)); // ensures that the 16th digit isn't 0
		for (int i = 0; i < 16; i++) {
			accumulator *= 10L;
			accumulator += rand.nextInt(10);
		}
		creditCard.setNumber(accumulator.toString());

		return creditCardService.save(creditCard);
	}

	private Double determineCreditLimit(Account account) {
		ClientType ct = account.getClient().getClientType();
		if (ct.equals(ClientType.BASIC)) {
			return 1000.00;
		} else if (ct.equals(ClientType.PREMIUM)) {
			return 5000.00;
		} else {
			return 15000.00;
		}
	}

	@PutMapping
	@Operation(summary = "Atualiza um cartão de credito")
	public CreditCard updateCreditCard(@RequestBody CreditCardDTO creditCardDto) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(creditCardDto, creditCard);
		return creditCardService.updateCard(creditCard);
	}

	public CreditCard getCardById(Integer creditCardId) {
		return creditCardService.getCardById(creditCardId);
	}

}
