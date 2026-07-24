package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status", "data" })
public class GetAlertPreference {
	
	private String status;
    private AlertPreferenceData data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AlertPreferenceData getData() {
		return data;
	}
	public void setData(AlertPreferenceData data) {
		this.data = data;
	}
    
    
    
    

}
