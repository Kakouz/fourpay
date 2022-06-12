package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.repository.CreditCardRepository;

@Service
public class CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	public List<CreditCard> findAll() {
		return creditCardRepository.findAll();
	}

	public CreditCard save(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	public CreditCard updateCard(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	public CreditCard getCardById(Integer id) {
		List<CreditCard> cardList = findAll();

		for (CreditCard card : cardList) {
			if (card.getAccount().getId().equals(id));
			return card;
		}

		return null;
	}
}
