package br.com.fourcamp.fourpay.dto;

import br.com.fourcamp.fourpay.enums.TransactionType;

public class TransactionDTO {
	private Double value;
	private TransactionType transactionType;
	private Integer payerAccountId;
	private Integer receiverAccountId;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
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
