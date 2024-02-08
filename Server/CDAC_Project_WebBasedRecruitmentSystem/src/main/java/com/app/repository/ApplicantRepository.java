package com.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ApplicantEntity;


public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long> {

	
}
