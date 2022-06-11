package br.com.fourcamp.fourpay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourcamp.fourpay.dto.InsuranceDTO;
import br.com.fourcamp.fourpay.model.Insurance;
import br.com.fourcamp.fourpay.service.InsuranceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/insurance")
@Api(value="API REST Insurance")
@CrossOrigin(origins = "*")
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os seguros")
	public List<Insurance> getAllInsurance() {
		return insuranceService.findAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria um novo seguro")
	public Insurance createInsurance(@RequestBody InsuranceDTO insuranceDto) {
		Insurance insurance = new Insurance();
		BeanUtils.copyProperties(insuranceDto, insurance);
		return insuranceService.save(insurance);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um seguro")
	public Insurance updateInsurance(@RequestBody InsuranceDTO insuranceDto) {
		Insurance insurance = new Insurance();
		BeanUtils.copyProperties(insuranceDto, insurance);
		return insuranceService.updateInsurance(insurance);
	}
}
