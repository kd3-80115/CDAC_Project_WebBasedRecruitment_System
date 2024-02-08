package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.request.HrRegistrationDetailsRequest;
import com.app.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/registerHr")
	public ResponseEntity<?> registerHr(@RequestBody HrRegistrationDetailsRequest hr){
		String message=adminService.registerHr(hr);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
}
