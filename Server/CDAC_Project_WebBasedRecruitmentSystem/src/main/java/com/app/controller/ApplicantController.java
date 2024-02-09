package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.AddressEntity;
import com.app.entities.ApplicantEntity;
import com.app.entities.UserEntity;
import com.app.payload.response.AddressResp;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.UserDetailsResp;
import com.app.repository.AddressRepository;
import com.app.service.AddressService;
import com.app.service.ApplicantService;
import com.app.service.UserService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private AddressService addressService;

//	@Autowired
//	private ApplicantService applicantService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicantService applicantService;
	
	public ApplicantController() {
		
	}
	
	//Rest API end point
	//URL : http://localhost:7878/applicant/address
	//Method : GET
	//Res : AddressResDTO
	@GetMapping("/address/{applicantId}")
	public ResponseEntity<?> getAddressDetails(@PathVariable Long applicantId){
		
		System.out.println("Inside applicant address endpoint with applicant ID : "+applicantId);
		
		AddressResp addressDTO = addressService.getAddress(applicantId);
		
		return new ResponseEntity<>(addressDTO,HttpStatus.OK);
		//send response as address details to be displayed on profile section of applicant
	}
	
	//Rest API end point
	//URL : http://localhost:7878/applicant/userDetail
	//Method : GET
	//Res : userDetailsResp
	@GetMapping("/userDetail/{applicantId}")
	public ResponseEntity<?> getBasicDetail(@PathVariable Long applicantId){
		
		System.out.println("Inside applicant userDetail endpoint with applicant ID : "+applicantId);
		
		UserDetailsResp userDetailsResp = userService.getBasicDetail(applicantId);
			
		return new ResponseEntity<>(userDetailsResp,HttpStatus.OK);
		//send response as user details to be displayed on profile section of applicant
	}
	
	
	//Rest API end point
	//URL : http://localhost:7878/applicant/profileInfo
	//Method : GET
	//Res : ApplicantResponse
	@GetMapping("/profileInfo/{applicantId}")
	public ResponseEntity<?> getProfileInfo(@PathVariable Long applicantId){
			
		System.out.println("Inside applicant getPRofileInfo endpoint with applicant ID : "+applicantId);
		
		ApplicantResponse applicantResponse = applicantService.getProfileInfo(applicantId);
			System.out.println("Applican response : "+ applicantResponse);
		return new ResponseEntity<>(applicantResponse,HttpStatus.OK);
		//send response as applicant details to be displayed on profile section of applicant
	}	
		
	
	
	
	
}
