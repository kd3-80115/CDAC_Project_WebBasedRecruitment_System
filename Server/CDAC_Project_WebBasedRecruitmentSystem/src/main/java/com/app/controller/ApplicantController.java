package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.response.AddressResp;
import com.app.payload.response.ApplicantResponse;
import com.app.payload.response.EducationResponse;
import com.app.payload.response.EmploymentResponse;
import com.app.payload.response.LanguageResponse;
import com.app.payload.response.ProjectResponse;
import com.app.payload.response.SchoolingResponse;
import com.app.payload.response.SkillResponse;
import com.app.payload.response.UserDetailsResp;
import com.app.service.AddressService;
import com.app.service.ApplicantService;
import com.app.service.EducationService;
import com.app.service.EmploymentService;
import com.app.service.ProjectService;
import com.app.service.SchoolingService;
import com.app.service.UserService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private SchoolingService schoolingService;

	@Autowired
	private EmploymentService employmentService;

	
	
	public ApplicantController() {

	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/address
	// Method : GET
	// Res : AddressResDTO
	@GetMapping("/address")
	public ResponseEntity<?> getAddressDetails() {

		System.out.println("inside address endpoint");

		AddressResp addressDTO = addressService.getAddress();

		return new ResponseEntity<>(addressDTO, HttpStatus.OK);
		// send response as address details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/userDetail
	// Method : GET
	// Res : userDetailsResp
	
	@GetMapping("/userDetail")
	public ResponseEntity<?> getBasicDetail() {
		System.out.println("inside profileInfo endpoint");
		
		UserDetailsResp userDetailsResp = userService.getBasicDetail();
		
		return new ResponseEntity<>(userDetailsResp, HttpStatus.OK);
		// send response as user details to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/profileInfo
	// Method : GET
	// Res : ApplicantResponse
	@GetMapping("/profileInfo")
	public ResponseEntity<?> getProfileInfo() {

		System.out.println("inside profileInfo endpoint");
		
		ApplicantResponse applicantResponse = applicantService.getProfileInfo();

		return new ResponseEntity<>(applicantResponse, HttpStatus.OK);
		// send response as applicant details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/educationDetails
	// Method : GET
	// Res : EducationResponse
	@GetMapping("/educationDetails")
	public ResponseEntity<?> getEducationDetails() {

		System.out.println("inside Education endpoint");
		List<EducationResponse> educationResponseList = educationService.getEducationDetail();

		return new ResponseEntity<>(educationResponseList, HttpStatus.OK);
		// send response as education details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/projectDetails
	// Method : GET
	// Res : projectResponse
	@GetMapping("/projectDetails")
	public ResponseEntity<?> getProjectDetails() {

		System.out.println("inside project endpoint");
		
		List<ProjectResponse> projectResponseList = projectService.getProjectDetail();

		return new ResponseEntity<>(projectResponseList, HttpStatus.OK);
		// send response as project details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/skills
	// Method : GET
	// Res : SkillResponse
	@GetMapping("/skills")
	public ResponseEntity<?> getSkills(Authentication auth) {

		System.out.println("inside getSkills endpoint with email : "+(String)auth.getPrincipal());

		List<SkillResponse> skillResponseList = applicantService.getAllSkills();

		return new ResponseEntity<>(skillResponseList, HttpStatus.OK);
		// send response as skill list to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/languages
	// Method : GET
	// Res : LanguagesResponse
	@GetMapping("/languages")
	public ResponseEntity<?> getLanguages() {

		System.out.println("inside language endpoint");

		List<LanguageResponse> LanguageResponseList = applicantService.getAllLanguages();

		return new ResponseEntity<>(LanguageResponseList, HttpStatus.OK);
		// send response as skill list to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/schooling
	// Method : GET
	// Res : SchoolingResponse
	@GetMapping("/schooling")
	public ResponseEntity<?> getSchoolingDetails() {

		System.out.println("inside schooling endpoint");

		SchoolingResponse schoolingResponse = schoolingService.getSchooling();

		return new ResponseEntity<>(schoolingResponse, HttpStatus.OK);
		// send response as schooling details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/employment
	// Method : GET
	// Res : EmploymentResponse
	@GetMapping("/employment")
	public ResponseEntity<?> getEmployment() {

		System.out.println("inside employment endpoint");

		List<EmploymentResponse> EmploymentResponseList = employmentService.getAllEmployment();

		return new ResponseEntity<>(EmploymentResponseList, HttpStatus.OK);
		// send response as skill list to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/basicDetails
	// Method : PUT
	// Res : BasicDetailRequest
//	@PutMapping("/basicDetails/{applicantId}")
//	public ResponseEntity<ApiResponse> updateBasicDetails(@PathVariable Long applicantId,@RequestBody @Valid BasicDetailRequest basicDetails ) {
//		ApiResponse apiResponse=userService.updateBasicDetails(basicDetails);
//		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
//	}

}
