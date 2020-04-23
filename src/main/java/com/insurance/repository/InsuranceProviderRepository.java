package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.InsuranceProvider;



@Repository
public interface InsuranceProviderRepository extends JpaRepository<InsuranceProvider, Long> {}
