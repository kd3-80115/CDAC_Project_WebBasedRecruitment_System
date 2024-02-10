package com.app.service;



import org.springframework.security.core.Authentication;

import com.app.payload.request.BasicDetailRequest;
import com.app.payload.request.Signup;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.UserDetailsResp;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);

	UserDetailsResp getBasicDetail();
	
	ApiResponse updateBasicDetails(BasicDetailRequest basicDetails,Long applicantId);
}
