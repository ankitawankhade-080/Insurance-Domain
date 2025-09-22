package com.insurance.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Coverage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coverage_seq_genn")
	@SequenceGenerator(name = "coverage_seq_genn", sequenceName = "COVERAGE_SEQ", allocationSize = 1)
	private long coverage_Id;

	private String coverage_type;
	private double coverage_Amount;

	@ManyToOne
	@JoinColumn(name = "policy_Id")
	private Policy policy;

	

	public void setCoverage_Id(long coverage_Id) {
		this.coverage_Id = coverage_Id;
	}

	public long getCoverage_Id() {
		return coverage_Id;
	}

	public void setCoverage_type(String coverage_type) {
		this.coverage_type = coverage_type;
	}

	public String getCoverage_type() {
		return coverage_type;
	}

	public void setCoverage_Amount(double coverage_Amount) {
		this.coverage_Amount = coverage_Amount;
	}

	public double getCoverage_Amount() {
		return coverage_Amount;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Policy getPolicy() {
		return policy;
	}
	@Override
	public String toString() {
		return "Coverage [coverage_Id=" + coverage_Id + ", coverage_type=" + coverage_type + ", coverage_Amount="
				+ coverage_Amount + ", policy=" + policy + "]";
	}

}
