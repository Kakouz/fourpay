package br.com.fourcamp.fourpay.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "checkings_account")
public class CheckingsAccount extends Account {
	private Double maintenanceRate;

	public Double getMaintenanceRate() {
		return maintenanceRate;
	}

	public void setMaintenanceRate(Double maintenanceRate) {
		this.maintenanceRate = maintenanceRate;
	}

}
