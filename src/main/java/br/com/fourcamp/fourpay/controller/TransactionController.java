package br.com.fourcamp.fourpay.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.TransactionDTO;
import br.com.fourcamp.fourpay.model.Transaction;
import br.com.fourcamp.fourpay.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping
	public List<Transaction> getAllTransactions() {
		return transactionService.findAll();
	}

	@PostMapping
	public Transaction createNewTransaction(@RequestBody TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		transaction.setDateOfTransaction(LocalDateTime.now());
		return transactionService.save(transaction);
	}

	@PutMapping
	public Transaction updateTransaction(@RequestBody TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		transaction.setDateOfTransaction(LocalDateTime.now());
		return transactionService.updateTransaction(transaction);
	}
}
