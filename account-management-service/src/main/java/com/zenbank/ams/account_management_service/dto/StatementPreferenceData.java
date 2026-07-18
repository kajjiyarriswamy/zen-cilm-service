package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementPreferenceData {

	private Long accountId;
	private String preferenceId;
    private String statementType;
    private String statementFrequency;
    private String deliveryStatus;
    private String emailId;
    private String passwordProtected;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getPreferenceId() {
		return preferenceId;
	}
	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}
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
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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
