package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.app.entities.ApplicantEntity;
import com.app.entities.EducationEntity;
import com.app.entities.EmploymentEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.EducationResponse;
import com.app.payload.response.EmploymentResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.EmploymentEntityRepository;

@Service
@Transactional
public class EmploymentServiceImpl implements EmploymentService {
	
	@Autowired
	private EmploymentEntityRepository employmentRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Override
	public List<EmploymentResponse> getAllEmployment(Long applicantId) {
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("profile in education service", "Applicant ID", applicantId));
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		List<EmploymentEntity> employmentList =employmentRepo.findAllByApplicant(applicant).
				orElseThrow(()-> new ResourceNotFoundException
						("Education in education service", "Applicant ID", applicantId));
		
		
		return employmentList.stream().
					map(employment -> mapper.map(employment, EmploymentResponse.class)).
						collect(Collectors.toList());
	}
	
	
}
