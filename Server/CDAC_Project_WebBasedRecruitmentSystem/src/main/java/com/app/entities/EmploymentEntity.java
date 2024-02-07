package com.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employment")
@NoArgsConstructor
@Getter
@Setter
public class EmploymentEntity extends BaseEntity{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private ApplicantEntity applicant;
	
	@Column(columnDefinition = "BOOLEAN")
	private boolean currentlyEmployed;
	
	@Column(length = 20)
	private String employementType;
	
	private int experienceYears;
	
	private int experienceMonths;
	
	@Column(length = 100)
	private String currentCompanyName;
	
	@Column(length = 100)
	private String previousCompanyName;
	
	@Column(length = 30)
	private String currentDesignation;
	
	@Column(length = 30)
	private String previousDesignation;
	
	private int noticePeriod;
	
	@Column(columnDefinition = "TEXT")
	private String jobProfile;
	
	private String department;
	
	private int currentSalary;

	public EmploymentEntity(ApplicantEntity applicant, boolean currentlyEmployed, String employementType,
			int experienceYears, int experienceMonths, String currentCompanyName, String previousCompanyName,
			String currentDesignation, String previousDesignation, int noticePeriod, String jobProfile,
			String department, int currentSalary) {
		
		this.applicant = applicant;
		this.currentlyEmployed = currentlyEmployed;
		this.employementType = employementType;
		this.experienceYears = experienceYears;
		this.experienceMonths = experienceMonths;
		this.currentCompanyName = currentCompanyName;
		this.previousCompanyName = previousCompanyName;
		this.currentDesignation = currentDesignation;
		this.previousDesignation = previousDesignation;
		this.noticePeriod = noticePeriod;
		this.jobProfile = jobProfile;
		this.department = department;
		this.currentSalary = currentSalary;
	}
	
	
	
}