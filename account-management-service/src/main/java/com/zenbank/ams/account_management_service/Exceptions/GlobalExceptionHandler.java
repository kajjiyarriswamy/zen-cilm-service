package com.zenbank.ams.account_management_service.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler { 
	
	
	@ExceptionHandler(PassbookRequestException.class)
	public ResponseEntity<ErrorResponse> handleStatementPreferenceException(PassbookRequestException ex) {

		ErrorResponse response = new ErrorResponse();

		response.setStatus("FAILED");
		response.setErrorCode(ex.getErrorCode());
		response.setMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

		ErrorResponse response = new ErrorResponse();

		response.setStatus("FAILED");
		response.setErrorCode("GEN_001");
		response.setMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


