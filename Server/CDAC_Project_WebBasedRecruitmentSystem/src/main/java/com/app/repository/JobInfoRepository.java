package com.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.JobInfoEntity;
import com.app.payload.response.JobDetailsResponse;

public interface JobInfoRepository extends JpaRepository<JobInfoEntity, Long>{


	/**
	 * Using a custom query to retrieve job details along with user information
	 * */
	@Query("SELECT new com.app.payload.response.JobDetailsResponse(j.jobId, j.jobTitle, u.firstName, u.lastName, j.jobCreatedDate, j.applicationDeadline, j.location, j.vacancies) "
			+ "FROM UserEntity u JOIN JobInfoEntity j ON u.id = j.hr.id")
	List<JobDetailsResponse> findAllJobs();
	
	/**
	 * custom query to find no. of active jobs 
	 * */
	@Query("SELECT COUNT(j) FROM JobInfoEntity j WHERE j.applicationDeadline > CURRENT_DATE")
	Long countActiveJobs();
}
