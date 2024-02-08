package com.app.payload.response;

import com.app.entities.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrDetailsResponse {

	public Long id;
	public String firstName;
	public String lastName;
	public Gender gender;
	public String email;
	public String phoneNumber;
	public int yearOfExperience;
	public String qualification;
	public boolean status;
}
