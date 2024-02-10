package com.app.service;
import static com.app.utils.UserHelper.findUserById;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.UserEntity;
import com.app.payload.request.BasicDetailRequest;
import com.app.payload.request.Signup;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.UserDetailsResp;
import com.app.repository.ApplicantRepository;
import com.app.repository.UserEntityRepository;
import com.app.security.FindAuthenticationDetails;

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
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		
		return mapper.map(userDao.save(user), Signup.class);
	}

	@Override
	public UserDetailsResp getBasicDetail() {
		
		Long userId=findUser.getUserId();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by email
		//extracted from authentication object
				
		UserEntity user=findUserById(userId, userDao);
		
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
