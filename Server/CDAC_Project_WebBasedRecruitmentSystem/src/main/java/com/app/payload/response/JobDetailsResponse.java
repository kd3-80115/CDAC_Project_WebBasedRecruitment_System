package com.app.payload.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class JobDetailsResponse {

	public Long jobId;
	public String jobTitle;
	public String firstName;
	public String lastName;
	public LocalDate jobCreatedDate;
	public LocalDate applicationDeadline;
	public String location;
	private int vacancies;
	
	public JobDetailsResponse(Long jobId, String jobTitle, String firstName, String lastName, LocalDate jobCreatedDate,
			LocalDate applicationDeadline, String location, int vacancies) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobCreatedDate = jobCreatedDate;
		this.applicationDeadline = applicationDeadline;
		this.location = location;
		this.vacancies = vacancies;
	}
	
}
