package com.app.service;
import static com.app.utils.UserHelper.findUserByEmail; 
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.AddressEntity;
import com.app.entities.ApplicantEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.request.BasicDetailRequest;
import com.app.payload.request.Signup;
import com.app.payload.response.AddressResp;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.UserDetailsResp;
import com.app.repository.ApplicantRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityRepository userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;
	//dep
	
	
	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		
		return mapper.map(userDao.save(user), Signup.class);
	}

	@Override
	public UserDetailsResp getBasicDetail(Authentication auth) {
		
		String email=(String)auth.getPrincipal();
		
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
		UserEntity user=findUserByEmail(email, userDao);
		
		//dto <-- entity
		return mapper.map(user, UserDetailsResp.class);
	}
	
	
	@Autowired
	private ApplicantRepository applicantRepo;

	@Override
	public ApiResponse updateBasicDetails(BasicDetailRequest basicDetails,Long applicantId) {
		
		return null;
	}
	
	
	
	
}
