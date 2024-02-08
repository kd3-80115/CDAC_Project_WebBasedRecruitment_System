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
import com.app.payload.response.GetAddressResp;
import com.app.repository.AddressRepository;
import com.app.service.AddressService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private AddressService addressService;

//	@Autowired
//	private ApplicantService applicantService;
	
	public ApplicantController() {
		
	}
	
	//Rest API end point
	//URL : http://localhost:7878/applicant/address
	//Method : GET
	//Res : AddressResDTO
	@GetMapping("/address/{applicantId}")
	public ResponseEntity<?> getAddressDetails(@PathVariable Long applicantId){
		
		System.out.println("Inside applicant address endpoint with applicant ID : "+applicantId);
		
		GetAddressResp addressDTO = addressService.getAddress(applicantId);
		
		return new ResponseEntity<>(addressDTO,HttpStatus.OK);
		
	}
	
	//Rest API end point
		//URL : http://localhost:7878/applicant/basicDetail
		//Method : GET
		//Res : GetAddressResp
//		@GetMapping("/basicDetail/{applicantId}")
//		public ResponseEntity<?> getApplicantBasicDetails(@PathVariable Long applicantId){
//			
//			System.out.println("Inside applicant BasicDeatil endpoint with applicant ID : "+applicantId);
//			
//			GetAddressResp addressDTO = addressService.getBasicDetail(applicantId);
//			
//			return new ResponseEntity<>(addressDTO,HttpStatus.OK);
//			
//		}
	
	
	
	
}
