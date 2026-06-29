package com.zenbank.cilm.dto;

import com.zenbank.cilm.entity.CustomerPreferenceEntity;

public class CustomerPreferenceResponseDto {
	
	    private Long preferenceId;
	    private Long customerId;
	    private String language;
	    private String relationship;
	    private String communicationMode;
	    private Boolean emailEnabled;
	    private Boolean smsEnabled;
	    private Boolean marketingEnabled;

	    public static CustomerPreferenceResponseDto fromEntity(CustomerPreferenceEntity entity) {

	        CustomerPreferenceResponseDto dto = new CustomerPreferenceResponseDto();

	        dto.preferenceId = entity.getPreferenceId();
	        dto.customerId = entity.getCustomer().getId();
	        dto.language = entity.getLanguage();
	        dto.relationship = entity.getRelationship();
	        dto.communicationMode = entity.getCommunicationMode();
	        dto.emailEnabled = entity.getEmailEnabled();
	        dto.smsEnabled = entity.getSmsEnabled();
	        dto.marketingEnabled = entity.getMarketingEnabled();

	        return dto;
	    }

		public Long getPreferenceId() {
			return preferenceId;
		}

		public void setPreferenceId(Long preferenceId) {
			this.preferenceId = preferenceId;
		}

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
