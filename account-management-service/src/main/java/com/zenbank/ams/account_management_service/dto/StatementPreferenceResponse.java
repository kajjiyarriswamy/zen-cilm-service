package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementPreferenceResponse {

	private String status;
	private String message;
	private String preferenceId;
	private StatementPreferenceData data;

	public StatementPreferenceResponse() {
	    }

	public StatementPreferenceResponse(String status, String message, String preferenceId, StatementPreferenceData data) {

		this.status = status;
		this.message = message;
		this.preferenceId = preferenceId;
		this.data=data;
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

	public StatementPreferenceData getData() {
		return data;
	}

	public void setData(StatementPreferenceData data) {
		this.data = data;
	}
	
	
	
}
