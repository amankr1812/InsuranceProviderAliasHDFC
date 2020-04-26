package com.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.model.InsuranceProvider;
import com.insurance.repository.InsuranceProviderRepository;

@Service
public class InsuranceProviderService {

	@Autowired
	  private InsuranceProviderRepository insuranceProviderRepository;
	
	public List<InsuranceProvider> getAllPlan() {
		return insuranceProviderRepository.findAll();
	}
	
	public Optional<InsuranceProvider> getPlanById(Long id) {
		return insuranceProviderRepository.findById(id);
	}
	
	public List<InsuranceProvider> getPlanByType(String filter) {
		List<InsuranceProvider> list = new ArrayList<>();
		if(filter.equalsIgnoreCase("all")){
			list=getAllPlan();
		}
		else {
		for(InsuranceProvider ins:getAllPlan()) {
			String temp=ins.getInsuranceType().toLowerCase(); // life, health, vehicle(4 wheeler, 2 wheeler) etc
			if(temp.contains(filter)) {
				list.add(ins);
			}
		}
		}
		
		
		return list;
	}
	
	public InsuranceProvider createInsuranceProvider(InsuranceProvider insuranceProvider) {
		return insuranceProviderRepository.saveAndFlush(insuranceProvider);
	}
	
	public InsuranceProvider update(InsuranceProvider insuranceProvider) {
		return insuranceProviderRepository.saveAndFlush(insuranceProvider);
	}
	
	public void delete(InsuranceProvider insuranceProvider) {
		insuranceProviderRepository.delete(insuranceProvider);
	}

}
