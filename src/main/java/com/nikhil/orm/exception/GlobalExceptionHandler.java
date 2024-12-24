package com.nikhil.orm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nikhil.orm.payload.ApiResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//handler resource not found exception
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}

}
