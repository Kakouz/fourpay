package br.com.fourcamp.fourpay.dto;

import br.com.fourcamp.fourpay.model.Client;

public class CheckingsAccountDTO {

	private Integer id;
	private String number;
	private Double balance;
	private Client client;
	private Double maintenanceRate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getMaintenanceRate() {
		return maintenanceRate;
	}

	public void setMaintenanceRate(Double maintenanceRate) {
		this.maintenanceRate = maintenanceRate;
	}

}
