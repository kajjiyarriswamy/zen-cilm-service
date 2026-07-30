package com.zenbank.ams.account_management_service.dto;

public class DebitCardUpdateResponse {

    private String status;
    private String message;

    public DebitCardUpdateResponse() {
    }

    public DebitCardUpdateResponse(String status, String message) {
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
