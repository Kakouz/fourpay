package br.com.fourcamp.fourpay.enums;

public enum TransactionType {
	CREDITCARD(0), DEBITCARD(1), PIX(2);

	private Integer id;

	TransactionType(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
