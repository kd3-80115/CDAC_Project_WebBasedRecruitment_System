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
	// Payload : appliedJobRequest
	@PostMapping("/applyJob/{jobId}")
	public ResponseEntity<ApiResponse> applyJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.applyJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	

	// Rest API end point
	// URL : http://localhost:7878/job/applyJob
	// Method : POST
	// Payload : appliedJobRequest
	@DeleteMapping("/unApplyJob/{jobId}")
	public ResponseEntity<ApiResponse> unApplyJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.unApplyJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/getAppliedJob
	// Method : GET
	// Payload : JobInfoDetailsResponse
	@GetMapping("/getAppliedJob")
	public ResponseEntity<?> getAppliedJob() {
	
		List<JobInfoDetailsResponse> jobList=jobService.getAppliedJobFun();
		
		return new ResponseEntity<>(jobList,HttpStatus.OK);
	}
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/saveJob
	// Method : POST
	// Payload : Long
	@PostMapping("/saveJob/{jobId}")
	public ResponseEntity<ApiResponse> saveJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.saveJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/unSaveJob
	// Method : POST
	// Payload : Long
	@PostMapping("/unSaveJob/{jobId}")
	public ResponseEntity<ApiResponse> unSaveJob(@PathVariable @Valid Long jobId ) {
	
		ApiResponse apiResponse=jobService.unSaveJobFun(jobId);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	
	// Rest API end point
	// URL : http://localhost:7878/job/getSavedJob
	// Method : GET
	// Payload : JobInfoDetailsResponse
	@GetMapping("/getSavedJob")
	public ResponseEntity<?> getSavedJob() {
	
		List<JobInfoDetailsResponse> jobList=jobService.getSavedJobFun();
		
		return new ResponseEntity<>(jobList,HttpStatus.OK);
	}
}
