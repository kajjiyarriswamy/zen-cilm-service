package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAlertPreferenceResponse {

    private String status;

    private String message;

    private String preferenceId;

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

	public String getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}
    

}
