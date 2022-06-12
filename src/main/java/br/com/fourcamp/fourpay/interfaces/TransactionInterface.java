package br.com.fourcamp.fourpay.interfaces;

import br.com.fourcamp.fourpay.enums.TransactionType;

public interface TransactionInterface {
	
	public boolean discountRates(Integer accountId);

	boolean sendMoney(Integer payerAccountId, Integer receiverAccountId, Double value, TransactionType transactionType);
	
}
