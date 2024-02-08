package com.app.service;

import com.app.payload.request.Signup;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);
}
