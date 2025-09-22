package com.insurance.service;

import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;

public interface PolicyService {
	
	public PolicyResponse createPolicy(PolicyRequest request);
	
	public PolicyResponse viewPolicy(Long policyId);

	public PolicyResponse renewPolicy(Long policyId, PolicyRequest request);

	public PolicyResponse cancelPolicy(Long policyId);
}
