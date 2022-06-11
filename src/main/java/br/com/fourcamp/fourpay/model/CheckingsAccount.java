package br.com.fourcamp.fourpay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "checkings_account")
public class CheckingsAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double maintenanceRate;

	public Double getMaintenanceRate() {
		return maintenanceRate;
	}

	public void setMaintenanceRate(Double maintenanceRate) {
		this.maintenanceRate = maintenanceRate;
	}

}
