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
	
	@GetMapping
	@Operation(summary = "Retorna todos os cartões de debito")
	public List<DebitCard> getAllCards() {
		return debitCardService.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Cria um novo cartão de debito")
	public DebitCard createDebitCard(@RequestBody DebitCard DebitCardDto) {
		DebitCard debitCard = new DebitCard();
		BeanUtils.copyProperties(DebitCardDto, debitCard);
		return debitCardService.save(debitCard);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza o cartão de debito")
	public DebitCard updateDebitCard(@RequestBody DebitCard DebitCardDto) {
		DebitCard debitCard = new DebitCard();
		BeanUtils.copyProperties(DebitCardDto, debitCard);
		return debitCardService.updateCard(debitCard);
	}

}
