package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AppliedJob;

public interface AppliedJobRepository extends JpaRepository<AppliedJob, Long> {

}
