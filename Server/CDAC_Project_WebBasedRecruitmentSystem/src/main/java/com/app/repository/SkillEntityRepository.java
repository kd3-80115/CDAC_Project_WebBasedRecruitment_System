package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.SkillEntity;

public interface SkillEntityRepository extends JpaRepository<SkillEntity, Long> {
	
}
