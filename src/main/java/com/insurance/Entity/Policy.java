package com.insurance.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_seq_genn")
	@SequenceGenerator(name = "policy_seq_genn", sequenceName = "POLICIES_SEQ", allocationSize = 1)
	private long policy_Id;

	private long customer_id;
	private String policy_Number;
	private LocalDate start_Date;
	private LocalDate end_Date;
	private double premium_Amout;

	@Enumerated(EnumType.STRING)
	private PolicyStatus status;

	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	private List<Coverage> coverages;

	public void setPolicy_Id(long policy_Id) {
		this.policy_Id = policy_Id;
	}

	public long getPolicy_Id() {
		return policy_Id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setPolicy_Number(String policy_Number) {
		this.policy_Number = policy_Number;
	}

	public String getPolicy_Number() {
		return policy_Number;
	}

	public void setStart_Date(LocalDate start_Date) {
		this.start_Date = start_Date;
	}

	public LocalDate getStart_Date() {
		return start_Date;
	}

	public void setEnd_Date(LocalDate end_Date) {
		this.end_Date = end_Date;
	}

	public LocalDate getEnd_Date() {
		return end_Date;
	}

	public void setPremium_Amout(double premium_Amout) {
		this.premium_Amout = premium_Amout;
	}

	public double getPremium_Amout() {
		return premium_Amout;
	}

	public void setStatus(PolicyStatus status) {
		this.status = status;
	}

	public PolicyStatus getStatus() {
		return status;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}

	public List<Coverage> getCoverages() {
		return coverages;
	}

	@Override
	public String toString() {
		return "Policy [policy_Id=" + policy_Id + ", customer_id=" + customer_id + ", policy_Number=" + policy_Number
				+ ", start_Date=" + start_Date + ", end_Date=" + end_Date + ", premium_Amout=" + premium_Amout
				+ ", status=" + status + ", coverages=" + coverages + "]";
	}

	
	
}
