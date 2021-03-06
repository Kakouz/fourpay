package br.com.fourcamp.fourpay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fourcamp.fourpay.enums.PixKeyType;

@Entity
public class Pix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private PixKeyType pixKeyType;
	private String keyValue;
	private Boolean isActive;
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
