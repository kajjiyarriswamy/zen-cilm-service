package com.zenbank.ams.account_management_service.dto;

public class StatementPreferenceResponse {

	private String status;
	private String message;
	private String preferenceId;

	public StatementPreferenceResponse() {
	    }

	public StatementPreferenceResponse(String status, String message, String preferenceId) {

		this.status = status;
		this.message = message;
		this.preferenceId = preferenceId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}
	
	
}
