package com.zenbank.ams.account_management_service.exception;

public class ChequeBookRequestException extends RuntimeException {

    private final String errorCode;

    public ChequeBookRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
