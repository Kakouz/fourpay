package br.com.fourcamp.fourpay.enums;

public enum PixKeyType {
	CPF(0), EMAIL(1), CELLPHONE(2), RANDOM(3);

	private Integer id;

	PixKeyType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
