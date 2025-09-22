package com.insurance.dto;

public class CoverageResponse {

	private long coverage_Id;
	private String coverageType;
	private double coverageAmount;

	public CoverageResponse() {
		super();

	}

	public CoverageResponse(long coverage_Id, String coverageType, double coverageAmount) {
		super();
		this.coverage_Id = coverage_Id;
		this.coverageType = coverageType;
		this.coverageAmount = coverageAmount;
	}

	public void setCoverage_Id(long coverage_Id) {
		this.coverage_Id = coverage_Id;
	}

	public long getCoverage_Id() {
		return coverage_Id;
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
