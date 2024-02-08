package com.app.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.entities.Gender;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrRegistrationDetailsRequest {

	@NotBlank
	@Size(min = 3,max = 30,message = "first name is not valid")
	private String firstName;
	@NotBlank
	@Size(min = 3,max = 30,message = "last name is not valid")
	private String lastName;
	@NotBlank
	private Gender gender;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@Size(min = 10,max = 13,message = "mobile number is not valid")
	@Pattern(regexp = "^\\d{10}$")
	private String phoneNumber;
	@NotNull
	@Size(min = 10,max = 13,message = "mobile number is not valid")
	// TODO:implement the password regex
	private String password;
	
	@JsonProperty(access = Access.READ_ONLY) 
	private UserRole role=UserRole.ROLE_HR;
	
	@NotNull
	@Size(min = 10,max = 13,message = "enter valid location")
	private String officeLocation;
	
	@NotNull
	@Size(min = 10,max = 13,message = "enter valid department")
	private String department;
	
	@JsonProperty(access = Access.READ_ONLY)
	public boolean status =true;
}
