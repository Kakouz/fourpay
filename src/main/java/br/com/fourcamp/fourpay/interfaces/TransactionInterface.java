package br.com.fourcamp.fourpay.interfaces;

public interface TransactionInterface {
	
	public boolean sendMoney(Integer payerAccountId, Integer receiverAccountId, Double value);
	
	public boolean discountRates(Integer accountId);
	
}
