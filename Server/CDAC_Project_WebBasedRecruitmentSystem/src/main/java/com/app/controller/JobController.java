package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.JobInfoEntity;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.JobInfoDetailsResponse;
import com.app.service.JobInfoService;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobInfoService jobService;
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/applyJob
	// Method : POST
	// DTO : appliedJobRequest
	@PostMapping("/applyJob/{jobId}")
	public ResponseEntity<ApiResponse> applyJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.applyJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	

	// Rest API end point
	// URL : http://localhost:7878/job/applyJob
	// Method : POST
	// DTO : appliedJobRequest
	@DeleteMapping("/unApplyJob/{jobId}")
	public ResponseEntity<ApiResponse> unApplyJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.unApplyJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/getAppliedJob
	// Method : GET
	// DTO : appliedJobRequest
	@GetMapping("/getAppliedJob")
	public ResponseEntity<?> getAppliedJob() {
	
		List<JobInfoDetailsResponse> jobList=jobService.getAppliedJobFun();
		
		return new ResponseEntity<>(jobList,HttpStatus.OK);
	}

}
