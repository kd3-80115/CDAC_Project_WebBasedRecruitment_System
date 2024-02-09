package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.exception.ResourceNotFoundException;

import com.app.payload.response.ApplicantResponse;
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
	
}
