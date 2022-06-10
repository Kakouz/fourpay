package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.ClientAddressDTO;
import br.com.fourcamp.fourpay.model.Address;
import br.com.fourcamp.fourpay.model.Client;
import br.com.fourcamp.fourpay.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;
	@Autowired
	AddressController addressController;

	@GetMapping
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> createClient(@RequestBody ClientAddressDTO clientAddressDTO) {
		Client client = new Client();
		BeanUtils.copyProperties(clientAddressDTO, client);
		Address address = new Address();
		BeanUtils.copyProperties(clientAddressDTO, address);
		client.setAddress(address);
		addressController.saveAddress(address);
		return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
	}
}
