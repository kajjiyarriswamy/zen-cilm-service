package com.zenbank.ams.account_management_service.exception;

public class DebitCardException extends RuntimeException {

    private String errorCode;

    public DebitCardException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}