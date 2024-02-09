package com.app.payload.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDetailsResponse {

	public Long jobId;
	public String jobTitle;
	public String firstName;
	public String lastName;
	public LocalDate jobCreatedDate;
	public LocalDate applicationDeadline;
	public String location;
}
