package com.zenbank.cilm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "customer_preferences")
	public class CustomerPreference {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "preference_id")
	    private Long preferenceId;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	    @JsonBackReference
	    private Customer customer;

	    @Column(name = "language", length = 100)
	    private String language;

	    @Column(name = "relationship", length = 100)
	    private String relationship;

	    @Column(name = "communication_mode", length = 100)
	    private String communicationMode;

	    @Column(name = "email_enabled")
	    private Boolean emailEnabled;

	    @Column(name = "sms_enabled")
	    private Boolean smsEnabled;

	    @Column(name = "marketing_enabled")
	    private Boolean marketingEnabled;
	    
	    public CustomerPreference() {
	    }

	    public Long getPreferenceId() {
	        return preferenceId;
	    }

	    public void setPreferenceId(Long preferenceId) {
	        this.preferenceId = preferenceId;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
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

	


