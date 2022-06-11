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

import br.com.fourcamp.fourpay.dto.PolicyDTO;
import br.com.fourcamp.fourpay.model.Policy;
import br.com.fourcamp.fourpay.service.PolicyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/policy")
@Api(value="API REST Policy")
@CrossOrigin(origins = "*")
public class PolicyController {
	@Autowired
	PolicyService policyService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todas as apolices de seguro")
	public List<Policy> getAllPolicy() {
		return policyService.findAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria uma nova apolice de seguro")
	public Policy createPolicy(@RequestBody PolicyDTO policyDTO) {
		Policy policy = new Policy();
		BeanUtils.copyProperties(policyDTO, policy);
		return policyService.save(policy);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza uma apolice de seguro")
	public Policy updatePolicy(@RequestBody PolicyDTO policyDTO) {
		Policy policy = new Policy();
		BeanUtils.copyProperties(policyDTO, policy);
		return policyService.updatePolicy(policy);
	}
}
