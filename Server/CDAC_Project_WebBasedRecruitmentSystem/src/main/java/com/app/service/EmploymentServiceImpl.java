package com.app.service;

import static com.app.utils.ApplicantHelper.findApplicantByUser;
import static com.app.utils.UserHelper.findUserById;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.EmploymentEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.EmploymentResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.EmploymentEntityRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

@Service
@Transactional
public class EmploymentServiceImpl implements EmploymentService {
	
	@Autowired
	private EmploymentEntityRepository employmentRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public List<EmploymentResponse> getAllEmployment() {
	
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
		
		List<EmploymentEntity> employmentList =employmentRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "Applicant ID", applicant.getId()));
		
		
		return employmentList.stream().
					map(employment -> mapper.map(employment, EmploymentResponse.class)).
						collect(Collectors.toList());
	}
	
	
}
