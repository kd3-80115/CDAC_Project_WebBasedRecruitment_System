package com.app.service;

import static com.app.utils.ApplicantHelper.findApplicantByUser;
import static com.app.utils.UserHelper.findUserById;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.EducationEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.request.EducationRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EducationResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.EducationEntityRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private EducationEntityRepository EducationRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private  UserEntityRepository userRepo;
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public List<EducationResponse> getEducationDetail() {
		
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
		
		List<EducationEntity> educationList =EducationRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "Applicant ID", applicant.getId()));
		return educationList.stream().
				map(education -> mapper.map(education, EducationResponse.class)).
				collect(Collectors.toList());

		
	}

	@Override
	public ApiResponse addEducationFun(EducationRequest education) {
		
		
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		EducationEntity educationEntity=mapper.map(education, EducationEntity.class);
		educationEntity.setApplicant(applicant);
		
		EducationRepo.save(educationEntity);
		
		return new ApiResponse("Applicant Education added with id "+applicant.getId());
	
	}
	
	
	@Override
	public ApiResponse updateEducationFun(EducationRequest education) {
		
		
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		EducationEntity educationEntity=EducationRepo.findById(education.getId()).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "education ID", education.getId()));
		
		educationEntity.setCourse(education.getCourse());
		educationEntity.setCourseEndDate(education.getCourseEndDate());
		educationEntity.setCourseStartDate(education.getCourseStartDate());
		educationEntity.setEducationType(education.getEducationType());
		educationEntity.setSpecialization(education.getSpecialization());
		educationEntity.setUniversity(education.getUniversity());
		
		educationEntity.setApplicant(applicant);
		
		EducationRepo.save(educationEntity);
		
		return new ApiResponse("Applicant Education update with applicant id "+applicant.getId()+" and Education id " +education.getId());
	
	}
	
	
	
	
}
