package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.SchoolingEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.SchoolingResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.SchoolingEntityRepository;

@Service
@Transactional
public class SchoolingServiceImpl implements SchoolingService {
	
	@Autowired
	private SchoolingEntityRepository schoolingRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Override
	public SchoolingResponse getSchooling(Long applicantId) {
		
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("Applicant", "Applicant ID", applicantId));
		
		SchoolingEntity schooling= schoolingRepo.findByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Schooling in schooling service", "Applicant ID", applicantId));
		return mapper.map(schooling, SchoolingResponse.class);
	}

}
