package com.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.entities.ApplicantJobId;
import com.app.entities.AppliedJob;
import com.app.entities.JobStatus;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.ApiResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.AppliedJobRepository;
import com.app.security.FindAuthenticationDetails;


@Service
@Transactional
public class AppliedJobServiceImpl implements AppliedJobService {
	
	@Autowired
	private AppliedJobRepository appliedJobRepo;
	
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	
	@Override
	public ApiResponse updateStatusFun(Long jobId, String status) {
		
		Long userId=findUser.getUserId();
			
		AppliedJob appliedJob =appliedJobRepo.findById(new ApplicantJobId(jobId,userId)).
						orElseThrow(()-> new ResourceNotFoundException
								("Applied Job", "Applicant ID", userId));
		
		if(status.equalsIgnoreCase("INTERVIEW")) {
			appliedJob.setStatus(JobStatus.INTERVIEW);
		}
		else if(status.equalsIgnoreCase("REJECTED")) {
			appliedJob.setStatus(JobStatus.REJECTED);
		}
		appliedJobRepo.save(appliedJob);
		
		return new ApiResponse("AppliedJob status updated with jobId "+jobId);
	}

}
