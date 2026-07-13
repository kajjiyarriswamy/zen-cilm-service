package com.zenbank.cilm.dto;


public class CommonResponseDto {


    private String status;

    private String message;

    private String errorCode;


    public CommonResponseDto() {

    }


    public CommonResponseDto(
            String status,
            String message,
            String errorCode) {

        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


    

}