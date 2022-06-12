package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.Policy;
import br.com.fourcamp.fourpay.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	PolicyRepository policyRepository;

	public List<Policy> findAll() {
		return policyRepository.findAll();
	}

	public Policy save(Policy policy) {
		if (policy.getCreditCard() == null || policy.getInsurance() == null) {
			return null;
		}
		return policyRepository.save(policy);
	}

	public Policy updatePolicy(Policy policy) {
		return policyRepository.save(policy);
	}
}
