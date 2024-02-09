package com.app.service;

import com.app.payload.response.ApplicantResponse;

public interface ApplicantService {

	ApplicantResponse getProfileInfo(Long applicantId);

	

}
