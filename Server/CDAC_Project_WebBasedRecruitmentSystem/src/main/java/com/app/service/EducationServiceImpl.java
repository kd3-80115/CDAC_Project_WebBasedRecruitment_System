package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.EducationEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EdcuationResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.EducationEntityRepository;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private EducationEntityRepository EducationRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Override
	public EdcuationResponse getEducationDetail(Long applicantId) {
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("profile in education service", "Applicant ID", applicantId));
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		EducationEntity education =EducationRepo.findByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "Applicant ID", applicantId));
		return mapper.map(education, EdcuationResponse.class);
	}
	
	
}
