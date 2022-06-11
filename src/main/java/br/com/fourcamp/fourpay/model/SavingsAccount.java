package br.com.fourcamp.fourpay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "savings_account")
public class SavingsAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double yieldRate;

	public Double getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(Double yieldRate) {
		this.yieldRate = yieldRate;
	}

}
