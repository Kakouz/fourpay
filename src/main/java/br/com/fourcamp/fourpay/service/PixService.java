package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.Pix;
import br.com.fourcamp.fourpay.repository.PixRepository;

@Service
public class PixService {
	
	@Autowired
	PixRepository pixRepository;

	public Pix save(Pix pix) {
		return pixRepository.save(pix);
	}

	public List<Pix> findAll() {
		return pixRepository.findAll();
	}

	public Pix updatePix(Pix pix) {
		return pixRepository.save(pix);
	}


}
