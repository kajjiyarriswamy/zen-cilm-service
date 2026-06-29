package com.zenbank.cilm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerPreferenceRequestDto {
	
	    @NotNull
	    private Long customerId;

	    @NotBlank
	    private String language;

	    private String relationship;

	    private String communicationMode;

	    private Boolean emailEnabled;

	    private Boolean smsEnabled;

	    private Boolean marketingEnabled;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getRelationship() {
			return relationship;
		}

		public void setRelationship(String relationship) {
			this.relationship = relationship;
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
