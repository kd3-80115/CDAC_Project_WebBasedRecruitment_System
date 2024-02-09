package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.EducationEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EducationResponse;
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
	public List<EducationResponse> getEducationDetail(Long applicantId) {
		
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("profile in education service", "Applicant ID", applicantId));
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		List<EducationEntity> educationList =EducationRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "Applicant ID", applicantId));
		return educationList.stream().
				map(education -> mapper.map(education, EducationResponse.class)).
				collect(Collectors.toList());

		
	}
	
	
}
