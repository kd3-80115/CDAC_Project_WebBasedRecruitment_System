package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.DepartmentEntity;
import com.app.entities.HREntity;
import com.app.entities.JobInfoEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.request.JobDetailsRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.JobInfoDetailsResponse;
import com.app.repository.DepartmentEntityRepository;
import com.app.repository.HREntityRepository;
import com.app.repository.JobInfoRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private HREntityRepository hrRepo;

	@Autowired
	private JobInfoRepository jobRepo;

	@Autowired
	private UserEntityRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DepartmentEntityRepository deptRepo;

	@Override
	public ApiResponse createJob(JobDetailsRequest job, String email) {

		// get the user from database
		UserEntity user = userRepo.findByEmail(email).orElseThrow();

		// get the respective HR info from HR table
		HREntity hr = hrRepo.findById(user.getId()).orElse(null);

		// get the department from the table
		DepartmentEntity department = deptRepo.findById(job.getDepId())
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", job.getDepId()));

		// mapping the payload to job info
		JobInfoEntity createdJob = mapper.map(job, JobInfoEntity.class);
		createdJob.setHr(hr);
		createdJob.setDepartment(department);
		jobRepo.save(createdJob);
		return new ApiResponse("job created");
	}

	/**
	 * get the all jobs created by the HR
	 * @param{ String email}
	 * */
	@Override
	public List<JobInfoDetailsResponse> getAllJobsCreatedByHr(String email) {
		// get the user from database
			UserEntity user = userRepo.findByEmail(email).orElseThrow();
			Long hrId=user.getId();
		return jobRepo.findAllJobsByHrId(hrId);
	}

	/**
	 * get the job by job id
	 * */	
	@Override
	public JobInfoDetailsResponse getJobByHrAndJobId(String email, Long jobId) {
	// get the user from database
		UserEntity user = userRepo.findByEmail(email).orElseThrow();
		Long hrId=user.getId();
		return jobRepo.findJobByHrIdAndJobId(hrId, jobId);
	}

}
