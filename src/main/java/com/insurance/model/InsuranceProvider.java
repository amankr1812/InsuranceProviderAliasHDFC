
package com.insurance.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Entity
@Table(name = "insuranceProvider")
@EntityListeners(AuditingEntityListener.class)
public class InsuranceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "provider_name", nullable = false)
    private String providerName;
    
    @Column(name = "insurance_type", nullable = false)
    private String insuranceType;
    
    @Column(name = "insurance_amount", nullable = false)
    private int insuranceAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(int insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	@Override
	public String toString() {
		return "InsuranceProvider [id=" + id + ", providerName=" + providerName + ", insuranceType=" + insuranceType
				+ ", insuranceAmount=" + insuranceAmount + "]";
	}

    
    
    


  
}
