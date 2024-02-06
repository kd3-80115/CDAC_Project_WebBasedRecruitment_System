package com.app.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "applicants")
@NoArgsConstructor
@Getter
@Setter

public class ApplicantEntity extends BaseEntity {
	
	@OneToOne(cascade = CascadeType.ALL)
	
	private UserEntity user;
	
	@Column(name = "email_id_verify_status",columnDefinition = "BOOLEAN")
	private boolean emailIdVerifyStatus; 
	
	@Column(name = "mobile_num_verify_status",columnDefinition = "BOOLEAN")
	private boolean mobileNumVerifyStatus;
	
	@Column(columnDefinition = "TEXT")
	private String resumeLink;
	
	@Column(columnDefinition = "TEXT")
	private String resumeHeadLine;
	
	@Column(columnDefinition = "TEXT")
	private String profileSummary;
	
	@Column(columnDefinition = "TEXT")
	private String profilePictureLink;
	
	@Column(length = 10)
	private String maritalStatus;
	
//	@OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
//	private List<EducationEntity> education=new ArrayList<EducationEntity>();

	public ApplicantEntity(UserEntity user, boolean emailIdVerifyStatus, boolean mobileNumVerifyStatus,
			String resumeHeadLine, String profileSummary, String maritalStatus) {
		super();
		this.user = user;
		this.emailIdVerifyStatus = emailIdVerifyStatus;
		this.mobileNumVerifyStatus = mobileNumVerifyStatus;
		this.resumeHeadLine = resumeHeadLine;
		this.profileSummary = profileSummary;
		this.maritalStatus = maritalStatus;
	}
	
	
	
	
	
	
}
