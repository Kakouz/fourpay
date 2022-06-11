package br.com.fourcamp.fourpay.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "savings_account")
public class SavingsAccount extends Account {
	private Double yieldRate;

	public Double getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(Double yieldRate) {
		this.yieldRate = yieldRate;
	}

}
