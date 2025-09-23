package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.Entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Policy p WHERE p.policy_Number = :policyNumber")
    boolean existsByPolicyNumber(@Param("policyNumber") String policyNumber);
}

