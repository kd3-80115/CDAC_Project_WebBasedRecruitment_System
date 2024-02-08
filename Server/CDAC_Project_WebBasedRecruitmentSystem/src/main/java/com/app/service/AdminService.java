package com.app.service;

import java.util.List;import com.app.entities.JobInfoEntity;
import com.app.payload.request.HrRegistrationDetailsRequest;
import com.app.payload.response.AnalysisResponseAdmin;
import com.app.payload.response.HrDetailsResponse;
import com.app.payload.response.JobDetailsResponse;

public interface AdminService {

	
	//register hr
	public String registerHr(HrRegistrationDetailsRequest hr);
	
	
	//get list of all hr
	public List<HrDetailsResponse>  getAllHr();
	
	//get list of all jobs
	public List<JobDetailsResponse> getAllJobs();
	
	//delete hr
	public String deleteHrById(Long hrId);
	
	//deactivate hr
	public String deactivateHrById(Long hrId);
	
	//get no of {total hr,activehr,total jobs,openjobs,}
	public List<AnalysisResponseAdmin> getReport();
	
	
}
