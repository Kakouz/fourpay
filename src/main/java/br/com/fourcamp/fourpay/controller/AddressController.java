package br.com.fourcamp.fourpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.model.Address;
import br.com.fourcamp.fourpay.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	public Address saveAddress(Address address) {
		return addressService.save(address);
	}
}
