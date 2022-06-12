package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.DebitCard;
import br.com.fourcamp.fourpay.repository.DebitCardRepository;

@Service
public class DebitCardService {

	@Autowired
	DebitCardRepository debitCardRepository;

	public List<DebitCard> findAll() {
		return debitCardRepository.findAll();
	}

	public DebitCard save(DebitCard debitCard) {
		return debitCardRepository.save(debitCard);
	}

	public DebitCard updateCard(DebitCard debitCard) {
		return debitCardRepository.save(debitCard);
	}

	public DebitCard getCardById(Integer id) {
		List<DebitCard> cardList = findAll();
		for (DebitCard card : cardList) {
			if (card.getAccount().getId().equals(id));
			return card;
		}

		return null;
	}
}
