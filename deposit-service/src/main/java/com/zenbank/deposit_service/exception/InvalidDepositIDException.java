package com.zenbank.deposit_service.exception;

public class InvalidDepositIDException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDepositIDException(String msg) {
		
		super(msg);
	}

}
