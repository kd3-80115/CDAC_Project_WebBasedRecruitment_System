package com.app.service;

import java.util.List;

import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.SkillResponse;

public interface ApplicantService {

	ApplicantResponse getProfileInfo(Long applicantId);
	
	List<SkillResponse> getAllSkills(Long applicantId);
	
	List<LanguageResponse> getAllLanguages(Long applicantId);

}
