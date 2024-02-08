package com.app.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Gender;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Signup {
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	@NotBlank(message = "First Name required")
	private String firstName;
	private String lastName;
	@Email(message = "Invalid Email!!!")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String phoneNumber;
	
	@JsonProperty(access = Access.READ_ONLY) 
	private UserRole role=UserRole.ROLE_APPLICANT;
	
	private Gender gender;
	public Signup(String firstName, String lastName,
			String email, String password, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
	
}
