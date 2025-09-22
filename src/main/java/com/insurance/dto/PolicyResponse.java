package com.insurance.dto;

import java.time.LocalDate;
import java.util.List;

import com.insurance.Entity.Coverage;
import com.insurance.Entity.PolicyStatus;

public class PolicyResponse {

	private long policyId;
	private Long customerId;
	private String policyNumber;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double premiumAmount;
	private String status;
	private List<CoverageResponse> coverages;
	

	
	public PolicyResponse() {
		
	}

	

	public PolicyResponse(long policyId, Long customerId, String policyNumber, LocalDate startDate, LocalDate endDate,
			Double premiumAmount, String status, List<CoverageResponse> coverages) {
		super();
		this.policyId = policyId;
		this.customerId = customerId;
		this.policyNumber = policyNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.premiumAmount = premiumAmount;
		this.status = status;
		this.coverages = coverages;
	}



	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public void setStatus(String string) {
		this.status = string;
	}

	public String getStatus() {
		return status;
	}

	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}



	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setCoverages(List<CoverageResponse> coverages) {
		this.coverages = coverages;
	}

	public List<CoverageResponse> getCoverages() {
		return coverages;
	}



	



	


}
