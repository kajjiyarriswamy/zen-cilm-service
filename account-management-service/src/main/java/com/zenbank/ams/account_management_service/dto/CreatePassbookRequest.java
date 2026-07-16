package com.zenbank.ams.account_management_service.dto;

public class CreatePassbookRequest {

	private String customerId;

	private String accountNumber;

	private String requestType;

	private String requestMode;

	private String deliveryMode;

	private DeliveryAddressDto deliveryAddress;

	private String remarks;

	private String branchCode;

	private String branchName;

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

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestMode() {
		return requestMode;
	}

	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public DeliveryAddressDto getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddressDto deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String brachName) {
		this.branchName = brachName;
	}

}
