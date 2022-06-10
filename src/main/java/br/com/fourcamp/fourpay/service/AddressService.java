package br.com.fourcamp.fourpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.Address;
import br.com.fourcamp.fourpay.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	
}
