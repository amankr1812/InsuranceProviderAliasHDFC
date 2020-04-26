

package com.insurance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.exception.TypeMismatchException;
import com.insurance.model.InsuranceProvider;

import com.insurance.repository.InsuranceProviderRepository;
import com.insurance.service.InsuranceProviderService;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class InsuranceProviderController {


  @Autowired
  private InsuranceProviderService insuranceProviderService;

  @GetMapping("/insuranceProviders")
  public List<InsuranceProvider> getAllInsuranceProviders() {
	  return insuranceProviderService.getAllPlan();
  }
  
  @GetMapping("/insuranceProviders/filter/{filter}")
  public <T> List<InsuranceProvider> getInsuranceProvidersByFilter(@PathVariable(value = "filter") T filter)
  {
	  
	  String value;
      value=(String) filter;
      	    
      List<InsuranceProvider> filteredList =
  				 insuranceProviderService
  	            .getPlanByType(value);
  	            //.orElseThrow(() -> new ResourceNotFoundException("Insurance Of Type "+value+" Not Found "));
      	return filteredList;
	  
  }


  @GetMapping("/insuranceProviders/{id}")
  public <T> ResponseEntity<InsuranceProvider> getInsuranceProvidersById(@PathVariable(value = "id") T insuranceProvidersId)
      throws ResourceNotFoundException,TypeMismatchException {
	  long id;
	  String value;
      value=(String) insuranceProvidersId;
	  try{
		  id=Long.parseLong(value);
	  }catch(Exception e) {
  		throw new TypeMismatchException("Data Type Mismatch on the given ID");
	  }
// 		  InsuranceProvider insuranceProvider =
//      				  insuranceProviderRepository
//      	            .findById(id)
//      	            .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
//      	    return ResponseEntity.ok().body(insuranceProvider);
            
      	    
      	  InsuranceProvider insuranceProvider =
  				  insuranceProviderService
  	            .getPlanById(id)
  	            .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
      	return ResponseEntity.ok().body(insuranceProvider);
	  
  }

  
  @PostMapping("/insuranceProviders")
  public InsuranceProvider createInsuranceProvider(@Valid @RequestBody InsuranceProvider insuranceProvider) {
    //return insuranceProviderRepository.save(insuranceProvider);
	  return insuranceProviderService.createInsuranceProvider(insuranceProvider);
  }

  @PutMapping("/insuranceProviders/{id}")
  public <T> ResponseEntity<InsuranceProvider> updateInsuranceProviders(
      @PathVariable(value = "id") T insuranceProvidersId, @Valid @RequestBody InsuranceProvider insuranceProviderDetails)
      throws ResourceNotFoundException,TypeMismatchException {

	  long id;
	  String value;
      value=(String) insuranceProvidersId;
	  try{
		  id=Long.parseLong(value);
	  }catch(Exception e) {
  		throw new TypeMismatchException("Data Type Mismatch on the given ID");
	  }
	  
	  InsuranceProvider insuranceProvider =
			  insuranceProviderService
            .getPlanById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
	  
	  insuranceProvider.setInsuranceProviderName(insuranceProviderDetails.getInsuranceProviderName());
	  insuranceProvider.setPlanName(insuranceProviderDetails.getPlanName());
	  insuranceProvider.setInsuranceValidity(insuranceProviderDetails.getInsuranceValidity());
	  insuranceProvider.setUptoAge(insuranceProviderDetails.getUptoAge());
	  insuranceProvider.setFromAge(insuranceProviderDetails.getFromAge());
	  insuranceProvider.setInsuranceType(insuranceProviderDetails.getInsuranceType());
	  insuranceProvider.setInsuranceAmount(insuranceProviderDetails.getInsuranceAmount());
    final InsuranceProvider updatedInsuranceProvider = insuranceProviderService.update(insuranceProvider);
    return ResponseEntity.ok(updatedInsuranceProvider);
  }


//  @DeleteMapping("/insuranceProviders/{id}")
//  public <T> Map<String, Boolean> deleteInsuranceProviders(@PathVariable(value = "id") T insuranceProvidersId) 
//  throws ResourceNotFoundException,TypeMismatchException {
//	  
//	  long id;
//	  String value;
//      value=(String) insuranceProvidersId;
//	  try{
//		  id=Long.parseLong(value);
//	  }catch(Exception e) {
//  		throw new TypeMismatchException("Data Type Mismatch on the given ID");
//	  }
//	  
//	  InsuranceProvider insuranceProvider =
//			  insuranceProviderRepository
//            .findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
//
//	  insuranceProviderRepository.delete(insuranceProvider);
//    Map<String, Boolean> response = new HashMap<>();
//    response.put("deleted", Boolean.TRUE);
//    return response;
//  }
  
  @DeleteMapping("/insuranceProviders/{id}")
  public <T> ResponseEntity<InsuranceProvider> deleteInsuranceProviders(@PathVariable(value = "id") T insuranceProvidersId) 
  throws ResourceNotFoundException,TypeMismatchException {
	  
	  long id;
	  String value;
      value=(String) insuranceProvidersId;
	  try{
		  id=Long.parseLong(value);
	  }catch(Exception e) {
  		throw new TypeMismatchException("Data Type Mismatch on the given ID");
	  }
	  
	  InsuranceProvider insuranceProvider =
			  insuranceProviderService
            .getPlanById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));

	  insuranceProviderService.delete(insuranceProvider);
	  
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
}


