package com.zenbank.ams.account_management_service.dto;

public class BlockedResponseDto {
	private String status;
	private String Message;
	
	
	public BlockedResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BlockedResponseDto(String status, String message) {
		super();
		this.status = status;
		Message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}
	
	
	

}
