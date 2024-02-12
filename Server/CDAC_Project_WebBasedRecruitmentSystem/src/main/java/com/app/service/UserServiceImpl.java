package com.app.service;
import static com.app.utils.ApplicantHelper.findApplicantByUserId;
import static com.app.utils.UserHelper.findUserById;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.NoticePeriod;
import com.app.entities.UserEntity;
import com.app.payload.request.BasicDetailRequest;
import com.app.payload.request.PersonalDetailRequest;
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
	private ApplicantRepository applicantRepo;
	
	//dep
	@Autowired
	private FindAuthenticationDetails findUser;
	
	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		ApplicantEntity applicant=new ApplicantEntity(user, false, false, "0", "0", "0",NoticePeriod.FIFTEEN_DAYS_OR_LESS);
		applicantRepo.save(applicant);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		
		return mapper.map(userDao.save(user), Signup.class);
	}
	
	
	/**
	 * Get applicant Basic Details
	 * **/
	@Override
	public UserDetailsResp getBasicDetail() {
		
		Long userId=findUser.getUserId();
		
		//statically imported method from UserHelper class
		//to find persistent UserEntity by User Id
				
		UserEntity user=findUserById(userId, userDao);
		
		//dto <-- entity
		return mapper.map(user, UserDetailsResp.class);
	}
	
	
	/**
	 * Update applicant Basic Details
	 * **/
	@Override
	public ApiResponse updateBasicDetails(BasicDetailRequest basicDetails) {
		
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userDao);
		
		user.setFirstName(basicDetails.getFirstName());
		user.setLastName(basicDetails.getLastName());
		user.setPhoneNumber(basicDetails.getPhoneNumber());
		user.setEmail(basicDetails.getEmail());

		//statically imported method from ApplicantHelper class
		//to find persistent ApplicantEntity by userId
		ApplicantEntity applicant=findApplicantByUserId(userId, applicantRepo);
		
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		applicant.setNoticePeriod(basicDetails.getNoticePeriod());
		
		userDao.save(user);
		applicantRepo.save(applicant);
		return new ApiResponse("User with id "+userId+" Updated");
	}

	
	/**
	 * Update applicant Personal Details
	 * **/
	@Override
	public ApiResponse updatePersonalDetailFun(PersonalDetailRequest personalDetail) {
			
		Long userId=findUser.getUserId();
		//statically imported method from UserHelper class
		//to find persistent UserEntity by id		
		UserEntity user=findUserById(userId, userDao);
		
		user.setDob(personalDetail.getDob());
		user.setGender(personalDetail.getGender());
		userDao.save(user);

		//statically imported method from ApplicantHelper class
		//to find persistent ApplicantEntity by userId
		ApplicantEntity applicant=findApplicantByUserId(userId, applicantRepo);
		
		
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		applicant.setMaritalStatus(personalDetail.getMaritalStatus());
		applicantRepo.save(applicant);
		return new ApiResponse("Personal details update with id "+userId);
	}
	
	
	
	
}
