package com.app.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.app.payload.response.EducationResponse;

public interface EducationService {

	
	List<EducationResponse> getEducationDetail(	);

}
