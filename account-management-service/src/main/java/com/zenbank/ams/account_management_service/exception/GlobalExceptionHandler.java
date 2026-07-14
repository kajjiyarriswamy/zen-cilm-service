package com.zenbank.ams.account_management_service.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ExceptionErrorResponse> customerResourceNotFound(CustomerNotFound e){
		ExceptionErrorResponse error = new ExceptionErrorResponse("FAILED",
				"NOM_001",
				e.getMessage(),
				LocalDateTime.now());
		
		
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	

}
