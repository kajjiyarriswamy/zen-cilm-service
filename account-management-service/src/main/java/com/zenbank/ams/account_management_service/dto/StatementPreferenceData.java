package com.zenbank.ams.account_management_service.dto;

public class StatementPreferenceData {

	private String preferenceId;
    private String statementType;
    private String statementFrequency;
    private String emailId;
    private String passwordProtected;
    private String deliveryStatus;
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
