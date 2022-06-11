package br.com.fourcamp.fourpay.dto;

import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.model.Insurance;

public class PolicyDTO {
	private Integer id;
	private Integer policyNumber;
	private CreditCard creditCard;
	private Insurance insurance;
	private Double policyValue;
	private String descriptionOfConditions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Double getPolicyValue() {
		return policyValue;
	}

	public void setPolicyValue(Double policyValue) {
		this.policyValue = policyValue;
	}

	public String getDescriptionOfConditions() {
		return descriptionOfConditions;
	}

	public void setDescriptionOfConditions(String descriptionOfConditions) {
		this.descriptionOfConditions = descriptionOfConditions;
	}

}
