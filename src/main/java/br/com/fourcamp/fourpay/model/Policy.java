package br.com.fourcamp.fourpay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Policy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer policyNumber;
	@OneToOne
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private CreditCard creditCard;
	@OneToOne
	@JoinColumn(name = "insurance_id", referencedColumnName = "id")
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
