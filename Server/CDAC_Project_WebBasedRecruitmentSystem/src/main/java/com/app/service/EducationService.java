package com.app.service;

import java.util.List;

import com.app.payload.response.EducationResponse;

public interface EducationService {

	
	List<EducationResponse> getEducationDetail(Long applicantId);

}
