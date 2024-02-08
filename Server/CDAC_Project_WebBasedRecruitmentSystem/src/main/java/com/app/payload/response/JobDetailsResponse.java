package com.app.payload.response;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDetailsResponse {

	public Long jobId;
	public String jobTitle;
	public String postedByHr;
	public LocalDate postedOn;
	public String location;
	public boolean status;
}
