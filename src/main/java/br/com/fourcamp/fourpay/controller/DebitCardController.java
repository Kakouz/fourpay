package br.com.fourcamp.fourpay.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.DebitCardDTO;
import br.com.fourcamp.fourpay.enums.ClientType;
import br.com.fourcamp.fourpay.model.Account;
import br.com.fourcamp.fourpay.model.DebitCard;
import br.com.fourcamp.fourpay.service.DebitCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/card/debit")
@Tag(name="API REST Debit Card")
@CrossOrigin(origins = "*")
public class DebitCardController {
	@Autowired
	DebitCardService debitCardService;
	@Autowired
	CheckingsAccountController checkingsAccountController;
	@Autowired
	SavingsAccountController savingsAccountController;
	
	@GetMapping
	@Operation(summary = "Retorna todos os cartões de debito")
	public List<DebitCard> getAllCards() {
		return debitCardService.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Cria um novo cartão de debito")
	public DebitCard createDebitCard(@RequestBody DebitCardDTO debitCardDto) {
		DebitCard debitCard = new DebitCard();
		BeanUtils.copyProperties(debitCardDto, debitCard);
		debitCard.setAccount(checkingsAccountController.getAccountById(debitCardDto.getAccountId()));
		if (debitCard.getAccount() == null) {
			debitCard.setAccount(savingsAccountController.getAccountById(debitCardDto.getAccountId()));
			if (debitCard.getAccount() == null) {
				return null;
			}
		}
		debitCard.setFlag("MASTERCARD");
		debitCard.setIsActive(true);
		debitCard.setTransactionLimit(determineTransactionLimit(debitCard.getAccount()));
		Random rand = new Random();
		Long accumulator = (long) (1 + rand.nextInt(9)); // ensures that the 16th digit isn't 0
		for (int i = 0; i < 16; i++) {
			accumulator *= 10L;
			accumulator += rand.nextInt(10);
		}
		debitCard.setNumber(accumulator.toString());
		return debitCardService.save(debitCard);
	}
	
	private Double determineTransactionLimit(Account account) {
		ClientType ct = account.getClient().getClientType();
		if (ct.equals(ClientType.BASIC)) {
			return 300.00;
		} else if (ct.equals(ClientType.PREMIUM)) {
			return 1500.00;
		} else {
			return 3000.00;
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualiza o cartão de debito")
	public DebitCard updateDebitCard(@PathVariable Integer id, @RequestBody Double value) {
		DebitCard debitCard = debitCardService.getCardById(id);
		debitCard.setTransactionLimit(value);
		return debitCardService.updateCard(debitCard);
	}

}
