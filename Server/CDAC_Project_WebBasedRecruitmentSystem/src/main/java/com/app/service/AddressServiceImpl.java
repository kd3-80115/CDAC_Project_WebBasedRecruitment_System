package com.app.service;

import static com.app.utils.UserHelper.findUserById;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.AddressEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.AddressResp;
import com.app.repository.AddressRepository;
import com.app.repository.ApplicantRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

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
	
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override 
	public AddressResp getAddress() {
		
		Long userId=findUser.getUserId();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
		
		UserEntity user=findUserById(userId, userRepo);
		
		AddressEntity address= addressRepo.findByUser(user)
									.orElseThrow(()-> new ResourceNotFoundException
											("Address", "Applicant ID", userId));
				// Returns the value in case of non empty Optional
				// OR throws supplied exception
				
		
		return mapper.map(address, AddressResp.class);
	}

}
