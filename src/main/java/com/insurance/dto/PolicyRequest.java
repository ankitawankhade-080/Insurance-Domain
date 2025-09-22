package com.insurance.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PolicyRequest {

	private long policyId;
	
	@NotNull(message="Customer id is Required")
	private Long customerId;
	
	@NotBlank(message= "Policy number is Required")
	private String policyNumber;
	
	@NotNull(message="Start Date is Required")
	private LocalDate startDate;
	
	@NotNull(message ="End Date is Required")
	private LocalDate endDate;
	
	@Positive(message="Premium Amount Must be Greter Than 0")
	private Double premiumAmount;
	
	@NotEmpty(message="Must be one Coverage id Required")
	private List<CoverageRequest> coverages;

	private Integer extendsYear;

	public PolicyRequest() {

	}


	public PolicyRequest(long policyId, Long customerId, String policyNumber, LocalDate startDate, LocalDate endDate,
			Double premiumAmount, List<CoverageRequest> coverages, Integer extendsYear) {
		super();
		this.policyId = policyId;
		this.customerId = customerId;
		this.policyNumber = policyNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.premiumAmount = premiumAmount;
		this.coverages = coverages;
		this.extendsYear = extendsYear;
	}



	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public long getPolicyId() {
		return policyId;
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

	public void setCoverages(List<CoverageRequest> coverages) {
		this.coverages = coverages;
	}

	public List<CoverageRequest> getCoverages() {
		return coverages;
	}

	public void setExtendsYear(Integer extendsYear) {
		this.extendsYear = extendsYear;
	}

	public Integer getExtendsYear() {
		return extendsYear;
	}

}
