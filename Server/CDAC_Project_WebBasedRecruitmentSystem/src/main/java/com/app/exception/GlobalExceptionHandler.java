package com.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice 
public class GlobalExceptionHandler {

	// This class serves as a global exception handler for all REST controllers in the application.
    // The @RestControllerAdvice annotation enables centralized exception handling and allows
    // for the implementation of common error responses across multiple controllers.

    // By using @ExceptionHandler methods within this class, you can define how various exceptions
    // should be handled globally. 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("in method arg invalid " + e);
		
		Map<String, String> map =new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			map.put(fieldName, message);
		});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
}
