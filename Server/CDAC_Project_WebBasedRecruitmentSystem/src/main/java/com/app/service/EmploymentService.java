package com.app.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.app.payload.response.EmploymentResponse;

public interface EmploymentService {

	List<EmploymentResponse> getAllEmployment(Authentication auth);
	
}
