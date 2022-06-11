package br.com.fourcamp.fourpay.controller;

import java.time.LocalDateTime;
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

import br.com.fourcamp.fourpay.dto.TransactionDTO;
import br.com.fourcamp.fourpay.model.Transaction;
import br.com.fourcamp.fourpay.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/transaction")
@Tag(name="API REST Transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping
	@Operation(summary = "Retorna todas as transações")
	public List<Transaction> getAllTransactions() {
		return transactionService.findAll();
	}

	@PostMapping
	@Operation(summary = "Cria uma nova transação")
	public Transaction createNewTransaction(@RequestBody TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		transaction.setDateOfTransaction(LocalDateTime.now());
		return transactionService.save(transaction);
	}

	@PutMapping
	@Operation(summary = "Atualiza uma transação")
	public Transaction updateTransaction(@RequestBody TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		transaction.setDateOfTransaction(LocalDateTime.now());
		return transactionService.updateTransaction(transaction);
	}
}
