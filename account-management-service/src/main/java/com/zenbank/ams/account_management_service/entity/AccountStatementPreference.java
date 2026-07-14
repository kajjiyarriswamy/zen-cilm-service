package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="account_statement_preference")
public class AccountStatementPreference {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="preference_id")
	private Long preferenceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="account_id", nullable = false)
	private Account account;
	
	@Column(name="statement_type",length = 20, nullable = false)
	private String statementType;
	
	@Column(name="statement_frequency",length = 20, nullable = false)
	private String statementFrequency;
	
	@Column(name="email_id", length = 100)
	private String emailId;
	
	@Column(name="password_protected", length = 1)
	private String passwordProtected;
	
	@Column(name="delivery_status",length = 20)
	private String deliveryStatus;
	
	@Column(name="last_generated_date")
	private LocalDate lastGeneratedDate;
	
	@Column(name="created_by", length = 50)
	private String createdBy;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="updated_by", length = 50)
	private String updatedBy;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	 public AccountStatementPreference() {
		 
	    }
	 
	 
	 

	public AccountStatementPreference(Long preferenceId, Account account, String statementType,
			String statementFrequency, String emailId, String passwordProtected, String deliveryStatus,
			LocalDate lastGeneratedDate, String createdBy, LocalDateTime createdDate, String updatedBy,
			LocalDateTime updatedDate) {
		this.preferenceId = preferenceId;
		this.account = account;
		this.statementType = statementType;
		this.statementFrequency = statementFrequency;
		this.emailId = emailId;
		this.passwordProtected = passwordProtected;
		this.deliveryStatus = deliveryStatus;
		this.lastGeneratedDate = lastGeneratedDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}




	public Long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public LocalDate getLastGeneratedDate() {
		return lastGeneratedDate;
	}

	public void setLastGeneratedDate(LocalDate lastGeneratedDate) {
		this.lastGeneratedDate = lastGeneratedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
