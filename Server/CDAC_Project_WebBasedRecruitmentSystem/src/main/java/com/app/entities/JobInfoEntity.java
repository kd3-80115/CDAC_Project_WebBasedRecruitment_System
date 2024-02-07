package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_info")
public class JobInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="job_title",length=30)
	private String jobTitle;
	
	@Column(name="experience_required")
	private int experienceRequired;
	
	@Column(name="work_schedule",length = 30)
	@Enumerated(EnumType.STRING)
	private WorkSchedule workSchedule;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="location",length=30)
	private String location;
	
	@Column(name="job_created_date")
	private LocalDate jobCreatedDate;
	
	private String qualification;
	
	@ManyToOne(optional = true)
	private HREntity hr;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DepartmentEntity department;
	
}
