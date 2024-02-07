package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.JobInfoEntity;

public interface JobInfoRepository extends JpaRepository<JobInfoEntity, Long>{

}
