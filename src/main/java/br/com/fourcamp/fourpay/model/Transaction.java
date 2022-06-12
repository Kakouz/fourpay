package br.com.fourcamp.fourpay.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fourcamp.fourpay.enums.TransactionType;

@Entity
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	private Double value;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
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
