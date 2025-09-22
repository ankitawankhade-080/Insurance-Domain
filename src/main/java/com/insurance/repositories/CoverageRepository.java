package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.Entity.Coverage;

@Repository
public interface CoverageRepository extends JpaRepository<Coverage, Long>{

}
