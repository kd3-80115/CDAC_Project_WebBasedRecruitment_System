package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ApplicantEntity;

import com.app.entities.EmploymentEntity;

public interface EmploymentEntityRepository extends JpaRepository<EmploymentEntity, Long> {
	
	Optional<List<EmploymentEntity>> findAllByApplicant(ApplicantEntity applicant);
}
