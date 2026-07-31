package com.zenbank.deposit_service.exception;

public class InvalidDateRangeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidDateRangeException() {
		
		super("From Date cannot be greater than to Date.");
		// TODO Auto-generated constructor stub
	}
	
    public InvalidDateRangeException(String message) {
    	
    	super(message);
    }	

}
