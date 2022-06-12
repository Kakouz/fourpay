package br.com.fourcamp.fourpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourcamp.fourpay.model.Insurance;
import br.com.fourcamp.fourpay.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	public List<Insurance> findAll() {
		return insuranceRepository.findAll();
	}

	public Insurance save(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	public Insurance updateInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	public Insurance getInsuranceById(Integer insuranceId) {
		List<Insurance> insuranceList = findAll();
		for (Insurance insurance : insuranceList) {
			if(insurance.getId().equals(insuranceId)) {
				return insurance;
			}
		}
		return null;
	}
}
