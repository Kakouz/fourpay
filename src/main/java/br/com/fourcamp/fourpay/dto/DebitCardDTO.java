package br.com.fourcamp.fourpay.dto;

import br.com.fourcamp.fourpay.model.Account;

public class DebitCardDTO {

	private Integer id;
	private String number;
	private String flag;
	private String password;
	private Boolean isActive;
	private Account account;
	private Double transactionLimit;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Double getTransactionLimit() {
		return transactionLimit;
	}
	public void setTransactionLimit(Double transactionLimit) {
		this.transactionLimit = transactionLimit;
	}
	
	
}
