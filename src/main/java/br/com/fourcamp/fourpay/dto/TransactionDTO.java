package br.com.fourcamp.fourpay.dto;

import java.time.LocalDateTime;

import br.com.fourcamp.fourpay.enums.TransactionType;

public class TransactionDTO {
	protected Integer id;
	private Double value;
	private LocalDateTime dateOfTransaction;
	private TransactionType transactionType;
	private Integer payerAccountId;
	private Integer receiverAccountId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getPayerAccountId() {
		return payerAccountId;
	}

	public void setPayerAccountId(Integer payerAccountId) {
		this.payerAccountId = payerAccountId;
	}

	public Integer getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(Integer receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

}
