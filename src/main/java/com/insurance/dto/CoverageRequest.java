package com.insurance.dto;

public class CoverageRequest {

	private String coverageType;
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
