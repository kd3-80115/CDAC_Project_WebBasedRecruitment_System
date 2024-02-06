package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.HREntity;

public interface HREntityRepository extends JpaRepository<HREntity, Long> {

}
