package com.zenbank.deposit_service.exception;

public class DepositException extends RuntimeException {

    private final String errorCode;

    public DepositException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
