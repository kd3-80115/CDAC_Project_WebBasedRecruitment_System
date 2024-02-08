package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.AddressEntity;
import com.app.entities.ApplicantEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.AddressResp;
import com.app.repository.AddressRepository;
import com.app.repository.ApplicantRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	//dep : dao layer i/f
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Autowired
	private UserEntityRepository userRepo; 
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	
	@Override 
	public AddressResp getAddress(Long applicantId) {
		
		ApplicantEntity applicant=applicantRepo.findById(applicantId).
				orElseThrow(()-> new ResourceNotFoundException
						("Applicant", "Applicant ID", applicantId));
		
		
		
		UserEntity user = applicant.getUser();
		
		AddressEntity address= addressRepo.findByUser(user)
									.orElseThrow(()-> new ResourceNotFoundException
											("Address", "Applicant ID", applicantId));
				// Returns the value in case of non empty Optional
				// OR throws supplied exception
				
		
		return mapper.map(address, AddressResp.class);
	}

}
