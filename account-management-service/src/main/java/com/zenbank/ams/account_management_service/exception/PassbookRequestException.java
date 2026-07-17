package com.zenbank.ams.account_management_service.exception;

public class PassbookRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

    public PassbookRequestException(String errorCode,String message){

        super(message);

        this.errorCode=errorCode;
    }

    public String getErrorCode(){

        return errorCode; 
    }

}
