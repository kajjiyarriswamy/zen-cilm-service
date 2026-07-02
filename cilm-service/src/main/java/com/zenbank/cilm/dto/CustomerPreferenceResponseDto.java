package com.zenbank.cilm.dto;

public class CustomerPreferenceResponseDto {
	private String preferenceId;
    private String language;
    private String communicationMode;
    private Boolean emailEnabled;
    private Boolean smsEnabled;
    private Boolean marketingEnabled;

    public CustomerPreferenceResponseDto() {
    }

    public CustomerPreferenceResponseDto(String preferenceId,
                                         String language,
                                         String communicationMode,
                                         Boolean emailEnabled,
                                         Boolean smsEnabled,
                                         Boolean marketingEnabled) {
        this.preferenceId = preferenceId;
        this.language = language;
        this.communicationMode = communicationMode;
        this.emailEnabled = emailEnabled;
        this.smsEnabled = smsEnabled;
        this.marketingEnabled = marketingEnabled;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
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


}
