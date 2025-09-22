package com.insurance.dto;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.Positive;

public class CoverageRequest {

	@NotBlank(message="Coverage Type is Required")
	private String coverageType;
	
	@Positive(message="Coverage Amount Must be Greater Than 0")
	private double coverageAmount;

	public CoverageRequest() {

	}

	public CoverageRequest(String coverageType, double coverageAmount) {
		super();
		this.coverageType = coverageType;
		this.coverageAmount = coverageAmount;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public String getCoverageType() {
		return coverageType;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

}
