package com.zenbank.ams.account_management_service.dto;



public class AccountFreezeResponseDto {
	private String status;
    private String message;

    public AccountFreezeResponseDto() {
    }

    public AccountFreezeResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
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
}

