package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.AddressDTO;
import br.com.fourcamp.fourpay.model.Address;
import br.com.fourcamp.fourpay.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping
	public Address saveAddressFromClientCreation(Address address) {
		return addressService.save(address);
	}

	@PostMapping("/create")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.save(address);
	}

	@GetMapping
	public List<Address> findAddress() {
		return addressService.findAll();
	}

	@PutMapping("/{id}")
	public Address updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressDto, address);
		return addressService.updateById(id, address);
	}
}
