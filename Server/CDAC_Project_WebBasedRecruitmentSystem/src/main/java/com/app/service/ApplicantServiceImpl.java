package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.LanguageEntity;
import com.app.entities.SkillEntity;
import com.app.exception.ResourceNotFoundException;

import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;
import com.app.repository.ApplicantRepository;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	
	@Override
	public ApplicantResponse getProfileInfo(Long applicantId) {
		
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("profile", "Applicant ID", applicantId));
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
