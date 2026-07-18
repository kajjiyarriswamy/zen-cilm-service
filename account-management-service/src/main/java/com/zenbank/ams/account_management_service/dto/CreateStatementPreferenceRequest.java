package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
public class CreateStatementPreferenceRequest {

	@NotBlank(message = "Statement type is required")
	private String statementType;

	@NotBlank(message = "Statement frequency is required")
	private String statementFrequency;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String emailId;

	@NotBlank(message = "Password protected is required")
	private String passwordProtected;
	
	private String deliveryStatus;

	public String getStatementType() {
		return statementType;
	}

	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}

	public String getStatementFrequency() {
		return statementFrequency;
	}

	public void setStatementFrequency(String statementFrequency) {
		this.statementFrequency = statementFrequency;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPasswordProtected() {
		return passwordProtected;
	}

	public void setPasswordProtected(String passwordProtected) {
		this.passwordProtected = passwordProtected;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	
	

}
