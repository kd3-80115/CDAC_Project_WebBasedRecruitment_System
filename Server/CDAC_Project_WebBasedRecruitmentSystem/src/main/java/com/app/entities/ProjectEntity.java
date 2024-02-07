package com.app.entities;

import java.time.LocalDate;
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
@Table(name = "projects")
@NoArgsConstructor
@Getter
@Setter
public class ProjectEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private ApplicantEntity applicant;
	
	
	private String projectTitle;
	
	@Column(columnDefinition = "BOOLEAN")
	private boolean projectStatus;
	
	private LocalDate projectStartDate;
	
	private LocalDate projectEndDate;
	
	@Column(columnDefinition = "TEXT")
	private String projectDescription;

	public ProjectEntity(ApplicantEntity applicant,String projectTitle, boolean projectStatus,
			LocalDate projectStartDate, LocalDate projectEndDate, String projectDescription) {
		
		this.applicant = applicant;
		this.projectTitle = projectTitle;
		this.projectStatus = projectStatus;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectDescription = projectDescription;
	}
	
	
	
	
}
