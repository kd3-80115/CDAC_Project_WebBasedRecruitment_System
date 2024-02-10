package com.app.service;

import static com.app.utils.ApplicantHelper.findApplicantByUser;
import static com.app.utils.UserHelper.findUserByEmail;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.ProjectEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.EducationResponse;
import com.app.payload.response.ProjectResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.ProjectEntityRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectEntityRepository projectRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;

	@Override
	public List<ProjectResponse> getProjectDetail(Authentication auth) {
		
		String email=(String)auth.getPrincipal();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
				
		UserEntity user=findUserByEmail(email, userRepo);
		
		
		//statically imported method from ApplicantHelper class
		//to find persistent ApplicantEntity by User
		
		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		
		List<ProjectEntity> projectList =projectRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("project in project service", "email ID", email));
		
		return  projectList.stream().
				map(project -> mapper.map(project, ProjectResponse.class)).
				collect(Collectors.toList());
	}
	


}
