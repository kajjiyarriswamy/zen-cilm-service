package com.zenbank.ams.account_management_service.dto;

import com.zenbank.ams.account_management_service.entity.Account;

public class AccountResponseDto {
	
	private Long accountId;
	
	private String accountNumber;
	
	private String ifscCode;
		
	private String accountStatus;
	
	
	


	public AccountResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	
	public AccountResponseDto(Long accountId, String accountNumber, String ifscCode, String accountStatus) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.accountStatus = accountStatus;
	}







	

	public Long getAccountId() {
		return accountId;
	}







	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}







	public String getAccountNumber() {
		return accountNumber;
	}







	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}







	public String getIfscCode() {
		return ifscCode;
	}







	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}







	public String getAccountStatus() {
		return accountStatus;
	}







	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}







	public static AccountResponseDto fromEntity(Account account) {
		
		
		return new AccountResponseDto(
				
				account.getAccountId(),account.getAccountNumber(),account.getIfscCode(),account.getAccountStatus());	
		
	}
	
	
	
	
	
	
	
	

}
