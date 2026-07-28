package com.zenbank.ams.account_management_service.dto;

public class JointHolderResponse {

	
	private String status;
	private String message;
	private String holderId;
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
	public String getHolderId() {
		return holderId;
	}
	public void setHolderId(String holderId) {
		this.holderId = holderId;
	}
	
	
}
