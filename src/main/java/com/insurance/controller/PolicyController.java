package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;
import com.insurance.service.PolicyServiceImpl;

@RestController
@RequestMapping("/policies")
public class PolicyController {
	
	@Autowired
	private PolicyServiceImpl policyServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<PolicyResponse>   createPolicy(@RequestBody PolicyRequest policyRequest){
		PolicyResponse response=policyServiceImpl.createPolicy(policyRequest);
		return ResponseEntity.ok(response);
		
	}
	@GetMapping("/view/{id}")
	public  ResponseEntity<PolicyResponse> viewPolicy(@PathVariable("id") Long id){
		PolicyResponse response=policyServiceImpl.viewPolicy(id);
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping("/renew/{id}")
	public  ResponseEntity<PolicyResponse> renewPolicy(@PathVariable("id") Long id, @RequestBody PolicyRequest policyRequest){
		PolicyResponse response=policyServiceImpl.renewPolicy(id, policyRequest);
		return ResponseEntity.ok(response);
	
	}
	
	@PutMapping("/Cancel/{id}")
	public  ResponseEntity<PolicyResponse> cancelPolicy(@PathVariable("id") Long id){
		PolicyResponse response=policyServiceImpl.cancelPolicy(id);
		return ResponseEntity.ok(response);
	
	}

}
