package com.app.service;

import java.util.List;

import com.app.payload.request.JobDetailsRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.JobInfoDetailsResponse;

public interface JobService {

	//post method to post a job by HR
	public ApiResponse createJob(JobDetailsRequest job,String email);
	
	//get job lists created by HR only
	public List<JobInfoDetailsResponse> getAllJobsCreatedByHr(String email);
	
	//deactivate the job --job which are only created by the HR
	
	
	//get the particular job by id and HR name
	public JobInfoDetailsResponse getJobByHrAndJobId(String email,Long jobId);
	
	//get no. of vacancies opening in the job posted by HR
}
