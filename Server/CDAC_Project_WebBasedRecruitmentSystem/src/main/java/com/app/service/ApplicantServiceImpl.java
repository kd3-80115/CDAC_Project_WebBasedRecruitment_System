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
import com.app.entities.LanguageEntity;
import com.app.entities.SkillEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EmploymentResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.LanguageEntityRepository;
import com.app.repository.SkillEntityRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private SkillEntityRepository skillRepo;
	
	@Autowired
	private LanguageEntityRepository languageRepo;
	
	
	
	
	/**
	 * getting profile details
	 * */
	@Override
	public ApplicantResponse getProfileInfo() {
		
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

		return mapper.map(applicant, ApplicantResponse.class);
	}
	
	
	/**
	 * getting All Skills
	 * */
	@Override
	public List<SkillResponse> getAllSkills() {
		
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
		List<SkillEntity> skillList=applicant.getSkills().stream().collect(Collectors.toList());
		
		return skillList.stream().
				map(skill -> mapper.map(skill, SkillResponse.class)).
				collect(Collectors.toList());
	}
	
	
	/**
	 * getting All langauges
	 * */
	@Override
	public List<LanguageResponse> getAllLanguages() {
		
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
		
		List<LanguageEntity> languageList=applicant.getLanguages().stream().collect(Collectors.toList());
		
		return languageList.stream().
				map(language -> mapper.map(language, LanguageResponse.class)).
				collect(Collectors.toList());
	}
	
	
	/**
	 * Updating Applicant Headline
	 * */
	@Override
	public ApiResponse updateHeadLine(String headLine) {
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		applicant.setResumeHeadLine(headLine);
		applicantRepo.save(applicant);
		return new ApiResponse("Applicant headline updated with id "+applicant.getId());
	}

	
	/**
	 * Updating Applicant Skills
	 * */
	@Override
	public ApiResponse updateSkills(List<String> skillList) {
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		for (String skill : skillList) {
			SkillEntity skillEntity=skillRepo.findByName(skill).
					orElseThrow(()-> new ResourceNotFoundException
							("Skill", "name", skill));
			applicant.getSkills().add(skillEntity);
		}
		

		applicantRepo.save(applicant);
		
		return new ApiResponse("Applicant Skills updated with id "+applicant.getId());
	}

	
	/**
	 * Update applicant Language
	 * **/
	@Override
	public ApiResponse updateLanguage(List<LanguageResponse> languageList) {
		
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		for (LanguageResponse language : languageList) {
			LanguageEntity languageEntity=languageRepo.getLanguage(language.getName(),language.getProficiency()).
					orElseThrow(()-> new ResourceNotFoundException
							("Language", "name", language.getName()));
			applicant.getLanguages().add(languageEntity);
		}
		applicantRepo.save(applicant);
		
		return new ApiResponse("Applicant Language updated with id "+applicant.getId());
	}
	
	
	
	/**
	 * Updating Applicant Summary
	 * */
	@Override
	public ApiResponse updateProfileSmry(String summary) {
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userRepo);
		

		ApplicantEntity applicant=findApplicantByUser(user, applicantRepo);
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		applicant.setProfileSummary(summary);
		applicantRepo.save(applicant);
		return new ApiResponse("Applicant Profile summary updated with id "+applicant.getId());
	}

	
	
	
	
	
	
	
	
}
