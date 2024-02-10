package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.HREntity;
import com.app.payload.request.HrRequest;
import com.app.payload.request.JobDetailsRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.HrResponse;
import com.app.service.HrService;
import com.app.service.JobService;
import com.app.service.UserService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	private HrService hrService;
	
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public ResponseEntity<HrResponse> getHrDetails(Authentication auth)
	{
		String userEmail=(String)auth.getPrincipal();
		return new ResponseEntity<HrResponse>(hrService.getHrDetails(userEmail),HttpStatus.OK);
	}
	
	// TODO: Add the authorization head
	@PostMapping
	public ResponseEntity<ApiResponse> updateHr(@RequestBody HrRequest hr){
		return new ResponseEntity<ApiResponse>(hrService.updateHr(hr),HttpStatus.OK);
	}
	
	@PostMapping("/createjob")
	public ResponseEntity<ApiResponse> createJob(@RequestBody JobDetailsRequest job,Authentication auth)
	{
		String userEmail=(String)auth.getPrincipal();
		return new ResponseEntity<ApiResponse>(jobService.createJob(job, userEmail),HttpStatus.CREATED);
	}
	@GetMapping("/jobs")
	public ResponseEntity<?> getAllJobsCreatedByHr(Authentication auth)
	{
		String email=(String)auth.getPrincipal();
		return new ResponseEntity<>(jobService.getAllJobsCreatedByHr(email),HttpStatus.OK);
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<?> getAllJobsCreatedByHr(@PathVariable Long jobId,Authentication auth)
	{
		String email=(String)auth.getPrincipal();
		return new ResponseEntity<>(jobService.getJobByHrAndJobId(email,jobId),HttpStatus.OK);
	}
}
