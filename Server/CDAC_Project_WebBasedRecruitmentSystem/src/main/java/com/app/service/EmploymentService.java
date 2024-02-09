package com.app.service;

import java.util.List;

import com.app.payload.response.EmploymentResponse;

public interface EmploymentService {

	List<EmploymentResponse> getAllEmployment(Long applicantId);
	
}
