
package com.insurance.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Entity
@Table(name = "insuranceProviderPolicies")
@EntityListeners(AuditingEntityListener.class)
public class InsuranceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "insurance_policy_name", nullable = false)
    private String insurancePolicyName;

    @Column(name = "from_age", nullable = false)
    private int fromAge;
    
    @Column(name = "upto_age", nullable = false)
    private int uptoAge;
    
    @Column(name = "insurance_validity", nullable = false)
    private int insuranceValidity;
    
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

	public String getInsurancePolicyName() {
		return insurancePolicyName;
	}

	public void setInsurancePolicyName(String insurancePolicyName) {
		this.insurancePolicyName = insurancePolicyName;
	}

	public int getFromAge() {
		return fromAge;
	}

	public void setFromAge(int fromAge) {
		this.fromAge = fromAge;
	}

	public int getUptoAge() {
		return uptoAge;
	}

	public void setUptoAge(int uptoAge) {
		this.uptoAge = uptoAge;
	}

	public int getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(int insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
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

	public InsuranceProvider(long id, String insurancePolicyName, int fromAge, int uptoAge, int insuranceValidity,
			String insuranceType, int insuranceAmount) {
		super();
		this.id = id;
		this.insurancePolicyName = insurancePolicyName;
		this.fromAge = fromAge;
		this.uptoAge = uptoAge;
		this.insuranceValidity = insuranceValidity;
		this.insuranceType = insuranceType;
		this.insuranceAmount = insuranceAmount;
	}

	public InsuranceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InsuranceProvider [id=" + id + ", insurancePolicyName=" + insurancePolicyName + ", fromAge=" + fromAge
				+ ", uptoAge=" + uptoAge + ", insuranceValidity=" + insuranceValidity + ", insuranceType="
				+ insuranceType + ", insuranceAmount=" + insuranceAmount + "]";
	}


    


  
}
