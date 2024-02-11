package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantJobId;
import com.app.entities.AppliedJob;
import com.app.entities.JobStatus;

import com.app.payload.response.ApiResponse;
import com.app.repository.AppliedJobRepository;
import com.app.security.FindAuthenticationDetails;

@Service
@Transactional
public class JobInfoServiceImpl implements JobInfoService {
	
	@Autowired
	private AppliedJobRepository appliedJobRepo;
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public ApiResponse applyJobFun(Long jobId) {
		
		Long userId=findUser.getUserId();
		
		ApplicantJobId appliedJobId=new ApplicantJobId(jobId,userId);
		
		AppliedJob appliedJobEntity	=new AppliedJob(appliedJobId,JobStatus.APPLIED);
		// TODO:add logic to check if job id exist in job table
		appliedJobRepo.save(appliedJobEntity);
		return new ApiResponse("Applicant with ID : " +userId+" Applied for job with ID : "+jobId);
	}

	@Override
	public ApiResponse unApplyJobFun(Long jobId) {
		
		Long userId=findUser.getUserId();
		// TODO:add logic to check if job id exist in job table
		ApplicantJobId appliedJobId=new ApplicantJobId(jobId,userId);
		
		appliedJobRepo.deleteById(appliedJobId);
		
		return new ApiResponse("Applicant with ID : " +userId+" UnApplied for job with ID : "+jobId);
	}
	
	
}
