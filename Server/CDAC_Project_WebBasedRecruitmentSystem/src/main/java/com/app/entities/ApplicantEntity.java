package com.app.entities;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

public class ApplicantEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicantId;
	
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
	
	@ManyToMany
    @JoinTable(name = "applicant_skill",
               joinColumns = @JoinColumn(name = "applicant_id"),
               inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills = new HashSet<>();

	


	public ApplicantEntity(UserEntity user, boolean emailIdVerifyStatus, boolean mobileNumVerifyStatus,
			String resumeHeadLine, String profileSummary, String maritalStatus) {
		
		this.user = user;
		this.emailIdVerifyStatus = emailIdVerifyStatus;
		this.mobileNumVerifyStatus = mobileNumVerifyStatus;
		this.resumeHeadLine = resumeHeadLine;
		this.profileSummary = profileSummary;
		this.maritalStatus = maritalStatus;
	}
	
	public void addSkill(SkillEntity skill) {
		
		skills.add(skill);
		skill.getApplicants().add(this);
	}
	
	public void removeSkill(SkillEntity skill) {
		
		skills.remove(skill);
		skill.getApplicants().remove(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicantEntity other = (ApplicantEntity) obj;
		return Objects.equals(applicantId, other.applicantId);
	}
	
	// Many to many relation with job
	// one applicant can have multiple jobs saved as well as applied
	@ManyToMany(mappedBy = "applicant")
	private Set<JobInfoEntity> job=new HashSet<JobInfoEntity>();
	
	
	
	
	
}
