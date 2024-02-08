package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.AddressEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.GetAddressResp;
import com.app.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;
	
	@Override 
	public GetAddressResp getAddress(Long applicantId) {
		
		AddressEntity address= addressRepo.findById(applicantId)
				// Returns the value in case of non empty Optional
				// OR throws supplied exception
				.orElseThrow(()-> new ResourceNotFoundException
						("Address", "Applicant ID", applicantId));
		
		return mapper.map(address, GetAddressResp.class);
	}

}
