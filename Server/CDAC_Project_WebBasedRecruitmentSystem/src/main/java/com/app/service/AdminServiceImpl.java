package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.UserEntity;
import com.app.payload.request.HrRegistrationDetailsRequest;
import com.app.payload.response.AnalysisResponseAdmin;
import com.app.payload.response.HrDetailsResponse;
import com.app.payload.response.JobDetailsResponse;
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
	
	@Override
	public String registerHr(HrRegistrationDetailsRequest hr) {
		UserEntity user=mapper.map(hr, UserEntity.class);
		System.out.println(user);
		
		return null;
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
