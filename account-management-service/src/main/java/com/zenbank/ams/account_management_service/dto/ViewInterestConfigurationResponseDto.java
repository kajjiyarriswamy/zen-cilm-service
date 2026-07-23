package com.zenbank.ams.account_management_service.dto;

import java.util.List;

public class ViewInterestConfigurationResponseDto {
	private String status;
    private String message;
    private List<ViewInterestConfigurationDataDto>data;
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
	public List<ViewInterestConfigurationDataDto> getData() {
		return data;
	}
	public void setData(List<ViewInterestConfigurationDataDto> data) {
		this.data = data;
	}
	
}
