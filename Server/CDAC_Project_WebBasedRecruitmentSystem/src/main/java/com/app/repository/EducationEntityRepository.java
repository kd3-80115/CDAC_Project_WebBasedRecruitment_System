package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ApplicantEntity;
import com.app.entities.EducationEntity;

public interface EducationEntityRepository extends JpaRepository<EducationEntity, Long> {
	Optional<EducationEntity> findByApplicant(ApplicantEntity applicant);
}
