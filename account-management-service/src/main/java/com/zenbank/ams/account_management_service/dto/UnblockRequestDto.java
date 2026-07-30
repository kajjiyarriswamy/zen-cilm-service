package com.zenbank.ams.account_management_service.dto;

public class UnblockRequestDto {
	private String reason;

	public UnblockRequestDto() {
		super();
		
	}

	public UnblockRequestDto(String reason) {
		super();
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	

}
