package com.app.service;

import static com.app.utils.UserHelper.findUserByEmail;
import static com.app.utils.ApplicantHelper.findApplicantByUser;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.LanguageEntity;
import com.app.entities.SkillEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;

import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private UserEntityRepository userRepo;
	@Override
	public ApplicantResponse getProfileInfo(Authentication  auth) {
		
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

		return mapper.map(applicant, ApplicantResponse.class);
	}
	
	@Override
	public List<SkillResponse> getAllSkills(Long applicantId) {
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("Applicant", "Applicant ID", applicantId));
		// Returns the value in case of non empty Optional
				// OR throws supplied exception
		List<SkillEntity> skillList=applicant.getSkills().stream().collect(Collectors.toList());
		
		return skillList.stream().
				map(skill -> mapper.map(skill, SkillResponse.class)).
				collect(Collectors.toList());
	}
	
	@Override
	public List<LanguageResponse> getAllLanguages(Long applicantId) {
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("Applicant", "Applicant ID", applicantId));
		
		// Returns the value in case of non empty Optional
				// OR throws supplied exception
		
		List<LanguageEntity> languageList=applicant.getLanguages().stream().collect(Collectors.toList());
		
		return languageList.stream().
				map(language -> mapper.map(language, LanguageResponse.class)).
				collect(Collectors.toList());
	}
	
	
	
}
