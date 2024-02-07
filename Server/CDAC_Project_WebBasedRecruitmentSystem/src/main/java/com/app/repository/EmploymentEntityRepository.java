package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.EmploymentEntity;

public interface EmploymentEntityRepository extends JpaRepository<EmploymentEntity, Long> {

}
