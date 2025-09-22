package com.insurance.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.Entity.Coverage;
import com.insurance.Entity.Policy;
import com.insurance.Entity.PolicyStatus;
import com.insurance.dto.CoverageRequest;
import com.insurance.dto.CoverageResponse;
import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;
import com.insurance.repositories.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public PolicyResponse createPolicy(PolicyRequest request) {

		Policy policy = new Policy();

		policy.setCustomer_id(request.getCustomerId());
		policy.setPolicy_Number(request.getPolicyNumber());
		policy.setStart_Date(request.getStartDate());
		policy.setEnd_Date(request.getEndDate());
		policy.setPremium_Amout(request.getPremiumAmount());
		policy.setStatus(PolicyStatus.PENDING_PAYMENT);

		List<Coverage> list = new ArrayList<Coverage>();
		for (CoverageRequest cov : request.getCoverages()) {
			Coverage coverage = new Coverage();
			coverage.setCoverage_Amount(cov.getCoverageAmount());
			coverage.setCoverage_type(cov.getCoverageType());
			coverage.setPolicy(policy);

			list.add(coverage);

		}

		policy.setCoverages(list);

		Policy savedPolicy = policyRepository.save(policy);
		return mapToResponse(savedPolicy);
	}

	private PolicyResponse mapToResponse(Policy policy) {

		PolicyResponse policyResponse = new PolicyResponse();
		policyResponse.setCustomerId(policy.getCustomer_id());
		policyResponse.setPolicyNumber(policy.getPolicy_Number());
		policyResponse.setStartDate(policy.getStart_Date());
		policyResponse.setEndDate(policy.getEnd_Date());
		policyResponse.setPremiumAmount(policy.getPremium_Amout());

		policyResponse.setStatus(policy.getStatus().name());

		List<CoverageResponse> list1 = new ArrayList<CoverageResponse>();
		for (Coverage c : policy.getCoverages()) {
			CoverageResponse coverageResponse = new CoverageResponse();
			coverageResponse.setCoverage_Id(c.getCoverage_Id());
			coverageResponse.setCoverageAmount(c.getCoverage_Amount());
			coverageResponse.setCoverageType(c.getCoverage_type());
			list1.add(coverageResponse);

		}

		policyResponse.setCoverages(list1);
		return policyResponse;

	}

	@Override
	public PolicyResponse viewPolicy(Long policyId) {
		Policy viewPolicy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy not found"));
		;

		PolicyResponse policyResponse = new PolicyResponse();

		policyResponse.setPolicyId(viewPolicy.getPolicy_Id());
		policyResponse.setCustomerId(viewPolicy.getCustomer_id());
		policyResponse.setPolicyNumber(viewPolicy.getPolicy_Number());
		policyResponse.setStartDate(viewPolicy.getStart_Date());
		policyResponse.setEndDate(viewPolicy.getEnd_Date());
		policyResponse.setPremiumAmount(viewPolicy.getPremium_Amout());

		policyResponse.setStatus(viewPolicy.getStatus().name());

		List<CoverageResponse> list1 = new ArrayList<CoverageResponse>();
		for (Coverage c : viewPolicy.getCoverages()) {
			CoverageResponse coverageResponse = new CoverageResponse();
			coverageResponse.setCoverage_Id(c.getCoverage_Id());
			coverageResponse.setCoverageAmount(c.getCoverage_Amount());
			coverageResponse.setCoverageType(c.getCoverage_type());
			list1.add(coverageResponse);

		}

		policyResponse.setCoverages(list1);

		return policyResponse;
	}

	@Override
	public PolicyResponse renewPolicy(Long policyId, PolicyRequest request) {

		Policy Policy = policyRepository.findById(policyId).orElseThrow(() -> new RuntimeException("Policy not found"));

		if (request.getExtendsYear() != null) {
			Policy.setEnd_Date(Policy.getEnd_Date().plusYears(request.getExtendsYear()));
		}

		if (request.getPremiumAmount() != null) {
			Policy.setPremium_Amout(request.getPremiumAmount());
		}

		Policy updatedpolicy = policyRepository.save(Policy);

		PolicyResponse policyResponse = new PolicyResponse();
		policyResponse.setPolicyId(updatedpolicy.getPolicy_Id());
		policyResponse.setCustomerId(updatedpolicy.getCustomer_id());
		policyResponse.setPolicyNumber(updatedpolicy.getPolicy_Number());
		policyResponse.setStartDate(updatedpolicy.getStart_Date());
		policyResponse.setEndDate(updatedpolicy.getEnd_Date());
		policyResponse.setPremiumAmount(updatedpolicy.getPremium_Amout());

		policyResponse.setStatus(updatedpolicy.getStatus().name());

		List<CoverageResponse> list1 = new ArrayList<CoverageResponse>();
		for (Coverage c : updatedpolicy.getCoverages()) {
			CoverageResponse coverageResponse = new CoverageResponse();
			coverageResponse.setCoverage_Id(c.getCoverage_Id());
			coverageResponse.setCoverageAmount(c.getCoverage_Amount());
			coverageResponse.setCoverageType(c.getCoverage_type());
			list1.add(coverageResponse);

			policyResponse.setCoverages(list1);
		}
		return policyResponse;
	}

	@Override
	public PolicyResponse cancelPolicy(Long policyId) {
		
		Policy Policy=policyRepository.findById(policyId).orElseThrow(() -> new RuntimeException("Policy not found"));
		Policy.setStatus(PolicyStatus.CANCELLED);
		Policy.setEnd_Date(LocalDate.now());
		
		Policy cancelledPolicy = policyRepository.save(Policy);
		
		PolicyResponse policyResponse = new PolicyResponse();
		policyResponse.setPolicyId(cancelledPolicy.getPolicy_Id());
		policyResponse.setCustomerId(cancelledPolicy.getCustomer_id());
		policyResponse.setPolicyNumber(cancelledPolicy.getPolicy_Number());
		policyResponse.setStartDate(cancelledPolicy.getStart_Date());
		policyResponse.setEndDate(cancelledPolicy.getEnd_Date());
		policyResponse.setPremiumAmount(cancelledPolicy.getPremium_Amout());

		policyResponse.setStatus(cancelledPolicy.getStatus().name());

		List<CoverageResponse> list1 = new ArrayList<CoverageResponse>();
		for (Coverage c : cancelledPolicy.getCoverages()) {
			CoverageResponse coverageResponse = new CoverageResponse();
			coverageResponse.setCoverage_Id(c.getCoverage_Id());
			coverageResponse.setCoverageAmount(c.getCoverage_Amount());
			coverageResponse.setCoverageType(c.getCoverage_type());
			list1.add(coverageResponse);

			policyResponse.setCoverages(list1);
		}
		return policyResponse;
		
		
	}
}
