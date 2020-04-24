
package com.insurance.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Entity
@Table(name = "insuranceProviderPolicies")
@EntityListeners(AuditingEntityListener.class)
public class InsuranceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long planId;
    
    @Column(name = "insurance_provider_name", nullable = false)
    private String insuranceProviderName;

    @Column(name = "plan_name", nullable = false)
    private String planName;
    
    @Column(name = "insurance_type", nullable = false)
    private String insuranceType;
    
    @Column(name = "from_age", nullable = false)
    private int fromAge;
    
    @Column(name = "upto_age", nullable = false)
    private int uptoAge;
    
    @Column(name = "insurance_validity", nullable = false)
    private int insuranceValidity;
    
    @Column(name = "insurance_amount", nullable = false)
    private int insuranceAmount;

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getInsuranceProviderName() {
		return insuranceProviderName;
	}

	public void setInsuranceProviderName(String insuranceProviderName) {
		this.insuranceProviderName = insuranceProviderName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
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

	public int getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(int insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	@Override
	public String toString() {
		return "InsuranceProvider [planId=" + planId + ", insuranceProviderName=" + insuranceProviderName
				+ ", planName=" + planName + ", insuranceType=" + insuranceType + ", fromAge=" + fromAge + ", uptoAge="
				+ uptoAge + ", insuranceValidity=" + insuranceValidity + ", insuranceAmount=" + insuranceAmount + "]";
	}

	public InsuranceProvider(long planId, String insuranceProviderName, String planName, String insuranceType,
			int fromAge, int uptoAge, int insuranceValidity, int insuranceAmount) {
		super();
		this.planId = planId;
		this.insuranceProviderName = insuranceProviderName;
		this.planName = planName;
		this.insuranceType = insuranceType;
		this.fromAge = fromAge;
		this.uptoAge = uptoAge;
		this.insuranceValidity = insuranceValidity;
		this.insuranceAmount = insuranceAmount;
	}

	public InsuranceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

  

  
}
