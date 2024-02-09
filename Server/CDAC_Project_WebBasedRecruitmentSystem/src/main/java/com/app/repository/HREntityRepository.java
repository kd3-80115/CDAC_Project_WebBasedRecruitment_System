package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.HREntity;

public interface HREntityRepository extends JpaRepository<HREntity, Long> {

	/**
	 * get active HR counts using custom query
	 * */
	@Query("SELECT COUNT(h) from HREntity h where activeStatus=true")
	Long countActiveUser();
}
