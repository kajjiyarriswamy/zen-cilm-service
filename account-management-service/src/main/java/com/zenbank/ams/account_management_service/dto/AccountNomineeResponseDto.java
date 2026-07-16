package com.zenbank.ams.account_management_service.dto;

public class AccountNomineeResponseDto {
	private String status;
    private String message;
    private String nomineeId;

    
    public AccountNomineeResponseDto() {
    }

    public AccountNomineeResponseDto(String status, String message, String nomineeId) {
        this.status = status;
        this.message = message;
        this.nomineeId = nomineeId;
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


    public String getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(String nomineeId) {
        this.nomineeId = nomineeId;
    }

}
