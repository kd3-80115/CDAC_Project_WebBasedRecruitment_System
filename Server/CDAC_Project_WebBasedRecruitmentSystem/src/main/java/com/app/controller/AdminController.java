package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.request.HrRegistrationDetailsRequest;
import com.app.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/registerHr")
	public ResponseEntity<?> registerHr(@RequestBody @Valid HrRegistrationDetailsRequest hr){
		System.out.println("Inside controller of hr");
		String message=adminService.registerHr(hr);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
}
