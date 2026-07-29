package com.zenbank.deposit_service.exception;

public class InvalidApprovalStatusException extends RuntimeException{
	
	public InvalidApprovalStatusException(String msg) {
		super(msg);
	}

}
