package com.app.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;

public interface ApplicantService {

	ApplicantResponse getProfileInfo(Authentication  auth);
	
	List<SkillResponse> getAllSkills(Authentication auth);
	
	List<LanguageResponse> getAllLanguages(Authentication auth);

}
