package com.app.utils;

import com.app.entities.ApplicantEntity;
import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ApplicantRepository;


//helper class to overcome frequently writing logic to find Applicant entity from user
public class ApplicantHelper {
	
	public static ApplicantEntity findApplicantByUser(UserEntity user,ApplicantRepository applicantRepo) {
		
		
		//finds persistent Applicant entity by user
		ApplicantEntity applicant=applicantRepo.findByUser(user).
				orElseThrow(()-> new ResourceNotFoundException
						("Applicant", "email", user.getEmail()));
		// Returns the value in case of non empty Optional
		// OR throws supplied exception
		
		return applicant;
	}
}
