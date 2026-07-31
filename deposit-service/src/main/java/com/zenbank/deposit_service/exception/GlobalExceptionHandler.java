package com.zenbank.deposit_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DepositNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDepositNotFound(DepositNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse(
				"FAILED",
				"DEP007",
				ex.getMessage()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidDepositIDException.class)
	public ResponseEntity<ErrorResponse> handleInvalidDepositID(InvalidDepositIDException ex){
		
		ErrorResponse error=new ErrorResponse(
				"FAILED",
				"DEP008",
				ex.getMessage()
				);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidDateRangeException.class)
	public ResponseEntity<ErrorResponse> InvalidDateRangeException(InvalidDateRangeException ex){
		
		ErrorResponse error=new ErrorResponse(
				"FAILED",
				"DEP012",
				ex.getMessage()
				);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidSearchParameterException.class)
	public ResponseEntity<ErrorResponse> InvalidSearchParameterException(InvalidSearchParameterException ex) {
		
		ErrorResponse error = new ErrorResponse(
		      "FAILED",
		      "DEP013",
		      ex.getMessage()
		      );
		      
		      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponse> handleException(Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                "FAILED",
	                "DEP500",
	                ex.getMessage());

	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	
	
	
	
	

}

