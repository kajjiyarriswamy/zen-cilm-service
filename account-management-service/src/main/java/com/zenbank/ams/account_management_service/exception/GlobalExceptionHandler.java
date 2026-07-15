package com.zenbank.ams.account_management_service.exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ExceptionErrorResponse> customerResourceNotFound(CustomerNotFound e){
		ExceptionErrorResponse error = new ExceptionErrorResponse("FAILED",
				"CUS_001",
				e.getMessage(),
				LocalDateTime.now());
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(StatementPreferenceException.class)
	public ResponseEntity<ErrorResponse> handleStatementPreferenceException(StatementPreferenceException ex) {

		ErrorResponse response = new ErrorResponse();

		response.setStatus("FAILED");
		response.setErrorCode(ex.getErrorCode());
		response.setMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ChequeBookRequestException.class)
	public ResponseEntity<ErrorResponse> handleChequeBookRequestException(ChequeBookRequestException ex) {

		ErrorResponse response = new ErrorResponse();

		response.setStatus("FAILED");
		response.setErrorCode(ex.getErrorCode());
		response.setMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorResponse response = new ErrorResponse();

		response.setStatus("FAILED");
		response.setMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new LinkedHashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {

			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			errors.put(field, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
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
