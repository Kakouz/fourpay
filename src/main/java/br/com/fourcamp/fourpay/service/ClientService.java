package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.Client;
import br.com.fourcamp.fourpay.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Object save(Client client) {
		return clientRepository.save(client);
	}

}
