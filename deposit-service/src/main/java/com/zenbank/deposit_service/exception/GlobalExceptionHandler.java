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
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponse> handleException(Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                "FAILED",
	                "DEP500",
	                ex.getMessage());

	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	//DepositReceiptTransaction
	
	@ExceptionHandler(DepositReceiptNotFound.class)
	public ResponseEntity<ErrorResponse>handleReceiptException(Exception ex){
		ErrorResponse error= new ErrorResponse(
				"FAILED",
				"RCP001",
				ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(ReceiptAlreadyGeneratedException.class)
	public ResponseEntity<ErrorResponse> handleAlreadyException(Exception ex){
		ErrorResponse error= new ErrorResponse(
				"FAILED",
				"RCP002",
				ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DepositTransactionFailedException.class)
	public ResponseEntity<ErrorResponse> handleFailedException(Exception ex){
		ErrorResponse error= new ErrorResponse(
				"FAILED",
				"RCP003",
				ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}

