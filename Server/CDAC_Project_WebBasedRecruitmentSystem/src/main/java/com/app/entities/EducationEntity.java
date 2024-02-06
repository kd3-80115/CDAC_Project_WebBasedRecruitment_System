package com.app.entities;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "educations")
@NoArgsConstructor

@Getter
@Setter

public class EducationEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(nullable = false)
	private ApplicantEntity applicant;
	
	@Column(name = "education_type", length = 30)
	private String educationType;
	
	@Column(length = 30)
	private String course;
	
	@Column(length = 100)
	private String university;
	
	@Column(length = 30)
	private String specialization;
	
	private LocalDate courseStartDate;
	
	private LocalDate courseEndDate;

	public EducationEntity(ApplicantEntity applicant, String educationType, String course, String university,
			String specialization, LocalDate courseStartDate, LocalDate courseEndDate) {
		
		this.applicant = applicant;
		this.educationType = educationType;
		this.course = course;
		this.university = university;
		this.specialization = specialization;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
	}
	
	
}
