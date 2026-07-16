package com.zenbank.ams.account_management_service.dto;

import org.hibernate.annotations.processing.Pattern;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateStatementPreferenceRequest {

	@NotBlank(message = "Statement type is required")
	@Pattern(regexp = "EMAIL|PHYSICAL|BOTH", message = "Statement type must be EMAIL, PHYSICAL or BOTH")
	private String statementType;

	@NotBlank(message = "Statement frequency is required")
	@Pattern(regexp = "DAILY|WEEKLY|MONTHLY|QUARTERLY", message = "Statement frequency must be DAILY, WEEKLY, MONTHLY or QUARTERLY")
	private String statementFrequency;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String emailId;

	@NotBlank(message = "Password protected is required")
	@Pattern(regexp = "Y|N", message = "Password protected must be Y or N")
	private String passwordProtected;

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

	

}
