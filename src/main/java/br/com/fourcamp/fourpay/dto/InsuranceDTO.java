package br.com.fourcamp.fourpay.dto;

public class InsuranceDTO {
	private Integer id;
	private String InsuranceName;
	private String rules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInsuranceName() {
		return InsuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		InsuranceName = insuranceName;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

}
