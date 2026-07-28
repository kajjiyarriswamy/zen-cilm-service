package com.zenbank.ams.account_management_service.exception;

public class AccountLimitError extends RuntimeException{
	public AccountLimitError(String message) {
		super(message);
	}
	
}
