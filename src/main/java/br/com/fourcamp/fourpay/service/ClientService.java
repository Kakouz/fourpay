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

	public Object updateClient(Client client) {
		clientRepository.getReferenceById(client.getId());
		return clientRepository.save(client);
	}

	public Client FindClientById(Integer clientId) {
		List<Client> listClients = findAll();
		
		for (Client item : listClients) {
			if(item.getId().equals(clientId)) {
				return item;
			}
		}
		return null;
	}

}
