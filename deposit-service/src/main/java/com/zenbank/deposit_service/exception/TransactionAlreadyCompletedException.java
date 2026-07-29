package com.zenbank.deposit_service.exception;

public class TransactionAlreadyCompletedException extends RuntimeException{
	
	public TransactionAlreadyCompletedException(String msg) {
		super(msg);
	}

}
