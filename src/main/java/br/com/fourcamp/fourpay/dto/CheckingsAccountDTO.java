package br.com.fourcamp.fourpay.dto;

public class CheckingsAccountDTO {

	private Double balance;
	private Integer clientId;


	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer client) {
		this.clientId = client;
	}

}
