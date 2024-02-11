package com.app.payload.request;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.ApplicantEntity;

public class EducationRequest {

	
	private Long id;
	
	
	private ApplicantEntity applicant;


	private String educationType;
	

	private String course;
	

	private String university;
	

	private String specialization;
	
	private LocalDate courseStartDate;
	
	private LocalDate courseEndDate;
	
}
