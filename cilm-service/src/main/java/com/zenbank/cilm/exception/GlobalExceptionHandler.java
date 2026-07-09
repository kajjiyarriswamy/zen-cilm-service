package com.zenbank.cilm.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
		
		 ErrorResponse error = new ErrorResponse(
	                "FAILED",
	                "NOM_001",
	                ex.getMessage(),
	                LocalDateTime.now());

	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	@ExceptionHandler(NomineeAlreadyVerifiedException.class)
	public ResponseEntity<ErrorResponse> handleAlreadyVerified(NomineeAlreadyVerifiedException ex) {
		
		ErrorResponse error = new ErrorResponse(
                "FAILED",
                "NOM_004",
                ex.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponse> handleException(Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                "FAILED",
	                "GEN_500",
	                ex.getMessage(),
	                LocalDateTime.now());

	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
