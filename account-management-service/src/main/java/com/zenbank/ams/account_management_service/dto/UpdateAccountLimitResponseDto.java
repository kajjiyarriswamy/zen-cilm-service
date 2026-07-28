package com.zenbank.ams.account_management_service.dto;

public class UpdateAccountLimitResponseDto {
	private String status;
	private String message;
	
	public UpdateAccountLimitResponseDto() {
		super();
	}
	public UpdateAccountLimitResponseDto(String status, String message) {
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
	
public static UpdateAccountLimitResponseDto fromEntity(String status, String message) {
	return new UpdateAccountLimitResponseDto(status,message);
	
}
}
