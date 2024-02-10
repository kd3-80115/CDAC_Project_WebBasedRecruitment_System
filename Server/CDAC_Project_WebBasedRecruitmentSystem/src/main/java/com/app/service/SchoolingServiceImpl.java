package com.app.service;

import static com.app.utils.ApplicantHelper.findApplicantByUser;
import static com.app.utils.UserHelper.findUserById;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.SchoolingEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.SchoolingResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.SchoolingEntityRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

@Service
@Transactional
public class SchoolingServiceImpl implements SchoolingService {
	
	@Autowired
	private SchoolingEntityRepository schoolingRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public SchoolingResponse getSchooling() {
		
		Long userId=findUser.getUserId();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
				
		UserEntity user=findUserById(userId, userRepo);
		
		
		//statically imported method from ApplicantHelper class
		//to find persistent ApplicantEntity by User
		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		
		SchoolingEntity schooling= schoolingRepo.findByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Schooling in schooling service", "Applicant ID", applicant.getId()));
		return mapper.map(schooling, SchoolingResponse.class);
	}

}
