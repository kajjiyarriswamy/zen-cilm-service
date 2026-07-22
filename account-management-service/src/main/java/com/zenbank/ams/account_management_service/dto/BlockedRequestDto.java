package com.zenbank.ams.account_management_service.dto;

public class BlockedRequestDto {
	private String reason;

	public BlockedRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlockedRequestDto(String reason) {
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
