package com.zenbank.ams.account_management_service.dto;

public class UnblockedResponseDto {
	
	private String status;
	
	private String message;

	public UnblockedResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnblockedResponseDto(String status, String message) {
		super();
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
