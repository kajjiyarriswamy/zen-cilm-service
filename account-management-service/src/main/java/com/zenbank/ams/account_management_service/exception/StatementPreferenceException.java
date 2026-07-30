package com.zenbank.ams.account_management_service.exception;

public class StatementPreferenceException extends RuntimeException {

	private String errorCode;

	public StatementPreferenceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
