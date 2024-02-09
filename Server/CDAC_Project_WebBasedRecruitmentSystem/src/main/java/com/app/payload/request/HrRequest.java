package com.app.payload.request;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class HrRequest {

	private Long id;
	private String qualification;
	private boolean status;
	private String imageURL;
	private Signup user;
}
