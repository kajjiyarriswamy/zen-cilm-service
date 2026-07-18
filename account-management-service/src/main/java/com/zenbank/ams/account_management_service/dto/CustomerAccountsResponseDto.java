package com.zenbank.ams.account_management_service.dto;

public class CustomerAccountsResponseDto {
	

	
	
	private String accountNumber;
	
	
	private String accountType;
	
	
	private String accountStatus;


	public CustomerAccountsResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerAccountsResponseDto(String accountNumber, String accountType, String accountStatus) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
	public static CustomerAccountsResponseDto fromEntity(String accountNumber,String accountType,String accountStatus) {
	return	new CustomerAccountsResponseDto(accountNumber,accountType,accountStatus);
	}
	
	
	
	

	

}
