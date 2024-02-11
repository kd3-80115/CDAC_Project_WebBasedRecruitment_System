package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.entities.LanguageEntity;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EmploymentResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;

public interface ApplicantService {

	ApplicantResponse getProfileInfo();
		
	List<SkillResponse> getAllSkills();
	
	List<LanguageResponse> getAllLanguages();

	ApiResponse updateHeadLine( String headLine);

	ApiResponse updateSkills( List<String> skills);

	ApiResponse updateLanguage( List<LanguageResponse> languages);

	ApiResponse updateProfileSmry(String summary);



}
