package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.interfaces.TransactionInterface;
import br.com.fourcamp.fourpay.model.Transaction;
import br.com.fourcamp.fourpay.repository.TransactionRepository;

@Service
public class TransactionService implements TransactionInterface{

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void SendMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discountRates() {
		// TODO Auto-generated method stub
		
	}

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}
