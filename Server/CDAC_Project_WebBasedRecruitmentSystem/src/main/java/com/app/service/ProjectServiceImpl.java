package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.ProjectEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.EducationResponse;
import com.app.payload.response.ProjectResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.ProjectEntityRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectEntityRepository projectRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;

	@Override
	public List<ProjectResponse> getProjectDetail(Long applicantId) {
		
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("profile in project service", "Applicant ID", applicantId));
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		List<ProjectEntity> projectList =projectRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("project in project service", "Applicant ID", applicantId));
		
		return  projectList.stream().
				map(project -> mapper.map(project, ProjectResponse.class)).
				collect(Collectors.toList());
	}
	


}
