package com.zenbank.ams.account_management_service.dto;

import jakarta.persistence.Column;

public class AccountRequestDto {
	
   private String customerId;
	
	
	private String accountNumber;
	
	
	private String accountType;
	
	private String branchCode;
	
	private String ifscCode;
	
	private String currency;
	
	private Double openingBalance;
	
	private Double availableBalance;
	
	private Double ledgerBalance;
	
	private String accountStatus;
	
	
	private String createdBy;
	
	
	


	public AccountRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}





	public AccountRequestDto(String customerId, String accountNumber, String accountType, String branchCode,
			String ifscCode, String currency, Double openingBalance, Double availableBalance, Double ledgerBalance,
			String accountStatus, String createdBy) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchCode = branchCode;
		this.ifscCode = ifscCode;
		this.currency = currency;
		this.openingBalance = openingBalance;
		this.availableBalance = availableBalance;
		this.ledgerBalance = ledgerBalance;
		this.accountStatus = accountStatus;
		this.createdBy = createdBy;
	}





	public String getCustomerId() {
		return customerId;
	}





	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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





	public String getBranchCode() {
		return branchCode;
	}





	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}





	public String getIfscCode() {
		return ifscCode;
	}





	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}





	public String getCurrency() {
		return currency;
	}





	public void setCurrency(String currency) {
		this.currency = currency;
	}





	public Double getOpeningBalance() {
		return openingBalance;
	}





	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}





	public Double getAvailableBalance() {
		return availableBalance;
	}





	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}





	public Double getLedgerBalance() {
		return ledgerBalance;
	}





	public void setLedgerBalance(Double ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}





	public String getAccountStatus() {
		return accountStatus;
	}





	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}





	public String getCreatedBy() {
		return createdBy;
	}





	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


     


	

}
