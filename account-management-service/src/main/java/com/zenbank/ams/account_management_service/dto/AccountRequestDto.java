package com.zenbank.ams.account_management_service.dto;

public class AccountRequestDto {
	
	private String customerId;
	
	private String accountType;
	
	private String branchCode;
	
	private String currency;
	
	private double initialDeposit;
	
	

	public AccountRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountRequestDto(String customerId, String accountType, String branchCode, String currency,
			double initialDeposit) {
		super();
		this.customerId = customerId;
		this.accountType = accountType;
		this.branchCode = branchCode;
		this.currency = currency;
		this.initialDeposit = initialDeposit;
	}




	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
	
	
	
	
	
	

}
