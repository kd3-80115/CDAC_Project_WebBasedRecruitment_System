package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.request.BasicDetailRequest;
import com.app.payload.response.AddressResp;
import com.app.payload.response.ApiResponse;
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
	public ResponseEntity<?> getAddressDetails(Authentication auth) {

		System.out.println("inside address endpoint with email : "+(String)auth.getPrincipal());

		AddressResp addressDTO = addressService.getAddress(auth);

		return new ResponseEntity<>(addressDTO, HttpStatus.OK);
		// send response as address details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/userDetail
	// Method : GET
	// Res : userDetailsResp
	
	@GetMapping("/userDetail")
	public ResponseEntity<?> getBasicDetail(Authentication auth) {
		
		System.out.println("inside userDetail endpoint with email : "+(String)auth.getPrincipal());


		

		UserDetailsResp userDetailsResp = userService.getBasicDetail(auth);
		
		return new ResponseEntity<>(userDetailsResp, HttpStatus.OK);
		// send response as user details to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/profileInfo
	// Method : GET
	// Res : ApplicantResponse
	@GetMapping("/profileInfo")
	public ResponseEntity<?> getProfileInfo(Authentication auth) {

		System.out.println("inside profileInfo endpoint with email : "+(String)auth.getPrincipal());


		ApplicantResponse applicantResponse = applicantService.getProfileInfo(auth);

		return new ResponseEntity<>(applicantResponse, HttpStatus.OK);
		// send response as applicant details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/educationDetails
	// Method : GET
	// Res : EducationResponse
	@GetMapping("/educationDetails")
	public ResponseEntity<?> getEducationDetails(Authentication auth) {

		System.out.println("inside EducationDetails endpoint with email : "+(String)auth.getPrincipal());

		List<EducationResponse> educationResponseList = educationService.getEducationDetail(auth);

		return new ResponseEntity<>(educationResponseList, HttpStatus.OK);
		// send response as education details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/projectDetails
	// Method : GET
	// Res : projectResponse
	@GetMapping("/projectDetails/{applicantId}")
	public ResponseEntity<?> getProjectDetails(@PathVariable Long applicantId) {

		System.out.println("Inside applicant getProjectDetails endpoint with applicant ID : " + applicantId);

		List<ProjectResponse> projectResponseList = projectService.getProjectDetail(applicantId);

		return new ResponseEntity<>(projectResponseList, HttpStatus.OK);
		// send response as project details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/skills
	// Method : GET
	// Res : SkillResponse
	@GetMapping("/skills/{applicantId}")
	public ResponseEntity<?> getSkills(@PathVariable Long applicantId) {

		System.out.println("Inside applicant getSkills endpoint with applicant ID : " + applicantId);

		List<SkillResponse> skillResponseList = applicantService.getAllSkills(applicantId);

		return new ResponseEntity<>(skillResponseList, HttpStatus.OK);
		// send response as skill list to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/languages
	// Method : GET
	// Res : LanguagesResponse
	@GetMapping("/languages/{applicantId}")
	public ResponseEntity<?> getLanguages(@PathVariable Long applicantId) {

		System.out.println("Inside applicant getLanguages endpoint with applicant ID : " + applicantId);

		List<LanguageResponse> LanguageResponseList = applicantService.getAllLanguages(applicantId);

		return new ResponseEntity<>(LanguageResponseList, HttpStatus.OK);
		// send response as skill list to be displayed on profile section of applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/schooling
	// Method : GET
	// Res : SchoolingResponse
	@GetMapping("/schooling/{applicantId}")
	public ResponseEntity<?> getSchoolingDetails(@PathVariable Long applicantId) {

		System.out.println("Inside applicant getSchoolingDetails endpoint with applicant ID : " + applicantId);

		SchoolingResponse schoolingResponse = schoolingService.getSchooling(applicantId);

		return new ResponseEntity<>(schoolingResponse, HttpStatus.OK);
		// send response as schooling details to be displayed on profile section of
		// applicant
	}

	// Rest API end point
	// URL : http://localhost:7878/applicant/employment
	// Method : GET
	// Res : EmploymentResponse
	@GetMapping("/employment/{applicantId}")
	public ResponseEntity<?> getEmployment(@PathVariable Long applicantId) {

		System.out.println("Inside applicant getEmployment endpoint with applicant ID : " + applicantId);

		List<EmploymentResponse> EmploymentResponseList = employmentService.getAllEmployment(applicantId);

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
