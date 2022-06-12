package br.com.fourcamp.fourpay.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
import br.com.fourcamp.fourpay.enums.ClientType;
import br.com.fourcamp.fourpay.model.CreditCard;
import br.com.fourcamp.fourpay.model.Policy;
import br.com.fourcamp.fourpay.service.PolicyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/policy")
@Tag(name = "API REST Policy")
@CrossOrigin(origins = "*")
public class PolicyController {
	@Autowired
	PolicyService policyService;
	@Autowired
	CreditCardController creditCardController;
	@Autowired
	InsuranceController insuranceController;

	@GetMapping
	@Operation(summary = "Retorna todas as apolices de seguro")
	public List<Policy> getAllPolicy() {
		return policyService.findAll();
	}

	@PostMapping
	@Operation(summary = "Cria uma nova apolice de seguro")
	public Policy createPolicy(@RequestBody PolicyDTO policyDto) {
		Policy policy = new Policy();
		policy.setCreditCard(creditCardController.getCardById(policyDto.getCreditCardId()));
		policy.setInsurance(insuranceController.getInsuranceById(policyDto.getInsuranceId()));
		policy.setPolicyNumber(UUID.randomUUID());
		policy.setPolicyValue(determinePolicyValueByClientStatus(policy.getCreditCard()));
		policy.setContractStartDate(LocalDate.now());
		policy.setDescriptionOfConditions("O cartão de crédito de número " + policy.getCreditCard().getNumber()
				+ " Está segurado pelo seguro " + policy.getInsurance().getInsuranceName()
				+ ". Com o valor por mês de " + policy.getPolicyValue() 
				+ ". Para acionar o seguro é preciso ligar para 4002-8922, falar com Yudi ou Priscilla");

		return policyService.save(policy);
	}

	private Double determinePolicyValueByClientStatus(CreditCard creditCard) {
		if (creditCard.getAccount().getClient().getClientType().equals(ClientType.BASIC)) {
			return 29.99;
		} else if (creditCard.getAccount().getClient().getClientType().equals(ClientType.PREMIUM)) {
			return 54.99;
		} else {
			return 80.00;
		}
	}

	@PutMapping
	@Operation(summary = "Atualiza uma apolice de seguro")
	public Policy updatePolicy(@RequestBody PolicyDTO policyDTO) {
		Policy policy = new Policy();
		BeanUtils.copyProperties(policyDTO, policy);
		return policyService.updatePolicy(policy);
	}
}
