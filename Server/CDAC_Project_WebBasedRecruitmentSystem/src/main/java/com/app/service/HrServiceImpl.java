package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.HREntity;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import com.app.payload.request.HrRequest;
import com.app.payload.request.Signup;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.HrResponse;
import com.app.repository.HREntityRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class HrServiceImpl implements HrService{

	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private HREntityRepository hrRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public HrResponse getHrDetails(String userName) {
		UserEntity user=userRepo.findByEmail(userName).orElseThrow();
		HREntity hrEntity=hrRepo.findByUser(user).orElseThrow();
		hrEntity.setUser(user);
		HrResponse hrResponse=mapper.map(hrEntity, HrResponse.class);
		System.out.println(hrResponse);
		return hrResponse;
	}

	//update hr info
	@Override
	public ApiResponse updateHr(HrRequest hr) {
		 if (hr.getUser() != null && hr.getUser().getEmail() != null) {
		     
			 //set the hr user id also same as user id
			 	hr.getUser().setId(hr.getId());
			 	
			 //encode the plain password	
			 	hr.getUser().setPassword(encoder.encode(hr.getUser().getPassword()));
			 // set the role as hr
			 	hr.getUser().setRole(UserRole.ROLE_HR);
			 // Retrieve the existing user from the database
		        UserEntity existingUser = userRepo.findById(hr.getId()).orElse(null);
		     // Retrieve the existing hr info from the database
		        HREntity exsistingHr=hrRepo.findById(hr.getId()).orElseThrow();
		        System.out.println(existingUser);
		        if (existingUser != null) {
		            // Map and save the updated user details
		            mapper.map(hr.getUser(), existingUser);
		            userRepo.save(existingUser);
		            
		            // Map and save the HR entity
		            mapper.map(hr, exsistingHr);
		            hrRepo.save(exsistingHr);
		            
		            return new ApiResponse("Hr Updated");
		        } else {
		            return new ApiResponse("User not found");
		        }
		    } else {
		        return new ApiResponse("Email cannot be null");
		    }
	}

}
