package com.zenbank.cilm.dto;

public class CustomerPreferenceResponseDto {
	private Long preferenceId;
    private String language;
    private String communicationMode;
    private Boolean emailEnabled;
    private Boolean smsEnabled;
    private Boolean marketingEnabled;
    private String status;
    private String message;
    

    public CustomerPreferenceResponseDto() {
    }
    
    
    


	public CustomerPreferenceResponseDto(Long preferenceId, String language, String communicationMode,
			Boolean emailEnabled, Boolean smsEnabled, Boolean marketingEnabled, String status, String message) {
		super();
		this.preferenceId = preferenceId;
		this.language = language;
		this.communicationMode = communicationMode;
		this.emailEnabled = emailEnabled;
		this.smsEnabled = smsEnabled;
		this.marketingEnabled = marketingEnabled;
		this.status = status;
		this.message = message;
	}





	public Long getPreferenceId() {
		return preferenceId;
	}


	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCommunicationMode() {
		return communicationMode;
	}


	public void setCommunicationMode(String communicationMode) {
		this.communicationMode = communicationMode;
	}


	public Boolean getEmailEnabled() {
		return emailEnabled;
	}


	public void setEmailEnabled(Boolean emailEnabled) {
		this.emailEnabled = emailEnabled;
	}


	public Boolean getSmsEnabled() {
		return smsEnabled;
	}


	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}


	public Boolean getMarketingEnabled() {
		return marketingEnabled;
	}


	public void setMarketingEnabled(Boolean marketingEnabled) {
		this.marketingEnabled = marketingEnabled;
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


	
}
