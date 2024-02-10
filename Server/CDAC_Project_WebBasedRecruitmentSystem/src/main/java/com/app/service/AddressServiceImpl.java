package com.app.service;

import static com.app.utils.UserHelper.findUserByEmail;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Override 
	public AddressResp getAddress(Authentication auth) {
		
		String email=(String)auth.getPrincipal();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
		
		UserEntity user=findUserByEmail(email, userRepo);
		
		AddressEntity address= addressRepo.findByUser(user)
									.orElseThrow(()-> new ResourceNotFoundException
											("Address", "Applicant ID", email));
				// Returns the value in case of non empty Optional
				// OR throws supplied exception
				
		
		return mapper.map(address, AddressResp.class);
	}

}
