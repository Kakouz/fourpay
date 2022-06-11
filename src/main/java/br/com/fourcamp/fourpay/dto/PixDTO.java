package br.com.fourcamp.fourpay.dto;

import br.com.fourcamp.fourpay.enums.PixKeyType;
import br.com.fourcamp.fourpay.model.CheckingsAccount;

public class PixDTO {
	private Integer id;
	private PixKeyType pixKeyType;
	private String keyValue;
	private Boolean isActive;
	private CheckingsAccount account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PixKeyType getPixKeyType() {
		return pixKeyType;
	}

	public void setPixKeyType(PixKeyType pixKeyType) {
		this.pixKeyType = pixKeyType;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public CheckingsAccount getAccount() {
		return account;
	}

	public void setAccount(CheckingsAccount account) {
		this.account = account;
	}

}
