package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.request.HrRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.HrResponse;
import com.app.service.HrService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	private HrService hrService;
	
	@GetMapping
	public ResponseEntity<HrResponse> getHrDetails(Authentication auth)
	{
		String userEmail=(String)auth.getPrincipal();
		return new ResponseEntity<HrResponse>(hrService.getHrDetails(userEmail),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> updateHr(@RequestBody HrRequest hr){
		return new ResponseEntity<ApiResponse>(hrService.updateHr(hr),HttpStatus.OK);
	}
}
