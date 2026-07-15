package com.zenbank.ams.account_management_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountLimitError.class)
	public ResponseEntity<ErrorResponse> accountIdNotFound(AccountLimitError ex){
		
		ErrorResponse er= new ErrorResponse( "FAILED","ACC_LIMIT_001",ex.getMessage());
			return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
		
	}

}
