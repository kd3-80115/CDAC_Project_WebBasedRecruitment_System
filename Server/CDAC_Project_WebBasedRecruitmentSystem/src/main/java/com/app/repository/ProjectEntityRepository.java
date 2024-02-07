package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ProjectEntity;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {

}
