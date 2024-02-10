package com.app.payload.response;

import java.time.LocalDate;

import com.app.entities.WorkSchedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter @NoArgsConstructor 
public class JobInfoDetailsResponse {

	private Long jobId;
	private String jobTitle;
	private int experienceRequired;
	private WorkSchedule workSchedule;
	private int salary;
	private LocalDate applicationDeadline;
	private LocalDate jobCreatedDate;
	private String qualification;
	private String departmentName;
	private int vacancies;
	private boolean status;
	public JobInfoDetailsResponse(long jobId, String jobTitle, int experienceRequired, WorkSchedule workSchedule, int salary, LocalDate applicationDeadline, LocalDate jobCreatedDate, String qualification, String departmentName, int vacancies,boolean status) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.experienceRequired = experienceRequired;
		this.workSchedule = workSchedule;
		this.salary = salary;
		this.applicationDeadline = applicationDeadline;
		this.jobCreatedDate = jobCreatedDate;
		this.qualification = qualification;
		this.departmentName = departmentName;
		this.vacancies = vacancies;
		this.status=status;
	}
	
	
}
