package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.HREntity;
import com.app.entities.UserEntity;
import com.app.payload.request.HrRegistrationDetailsRequest;
import com.app.payload.response.AnalysisResponseAdmin;
import com.app.payload.response.HrDetailsResponse;
import com.app.payload.response.JobDetailsResponse;
import com.app.repository.HREntityRepository;
import com.app.repository.UserEntityRepository;

@Service
public class AdminServiceImpl implements AdminService {

	//dep : dao layer i/f
	@Autowired
	private UserEntityRepository userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private HREntityRepository hrRepo;
	
	@Override
	@Transactional
	public String registerHr(HrRegistrationDetailsRequest hr) {
		String message = "something bad happened";
		
		// Create and save the user entity
	    UserEntity user = mapper.map(hr, UserEntity.class);
	    user.setPassword(encoder.encode(user.getPassword()));
	    UserEntity savedUser = userDao.save(user);

	    // Create the HR entity and set the user details
	    HREntity hrEntity = mapper.map(hr, HREntity.class);
	    hrEntity.setUser(savedUser);

	    // Use merge instead of persist to handle detached entities
	    HREntity savedHr = hrRepo.save(hrEntity);

	    // Check if the HR registration was successful
	    if (savedHr.getUser().getId() > 0) {
	        message = "HR registered successfully";
	    }
	    return message;
	}

	@Override
	public List<HrDetailsResponse> getAllHr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobDetailsResponse> getAllJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHrById(Long hrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deactivateHrById(Long hrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnalysisResponseAdmin> getReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
