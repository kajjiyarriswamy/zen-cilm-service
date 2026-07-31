package com.zenbank.deposit_service.exception;

public class InvalidSearchParameterException extends RuntimeException {
	
	public InvalidSearchParameterException () {
		
		super("Invalid search parameter");
		
	}
	
	public  InvalidSearchParameterException (String message) {
		
		super(message);
	}

}
