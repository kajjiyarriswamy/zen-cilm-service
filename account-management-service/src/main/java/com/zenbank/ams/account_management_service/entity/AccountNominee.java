package com.zenbank.ams.account_management_service.entity;

import java.math.BigDecimal;
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
@Table(name = "account_nominee")

public class AccountNominee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "nominee_id")
private Long nomineeId;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "account_id", nullable = false)
private Account accountId;
@Column(name = "nominee_name", nullable = false)
private String nomineeName;
@Column(name = "relationship", nullable = false)
private String relationship;
@Column(name = "mobile_number", nullable = false)
private String mobileNumber;
@Column(name = "dob", nullable = false)
private LocalDate dob;
@Column(name = "share_percentage", nullable = false)
private BigDecimal sharePercentage;
@Column(name = "verification_status", nullable = false)
private String verificationStatus;
@Column(name = "created_date", nullable = false)
private LocalDateTime createdDate;
@Column(name = "updated_date", nullable = false)
private LocalDateTime updatedDate;
public AccountNominee() {
}

public Long getNomineeId() {
	return nomineeId;
}
public void setNomineeId(Long nomineeId) {
	this.nomineeId = nomineeId;
}
public Account getAccountId() {
	return accountId;
}
public void setAccountId(Account accountId) {
	this.accountId = accountId;
}
public String getNomineeName() {
	return nomineeName;
}
public void setNomineeName(String nomineeName) {
	this.nomineeName = nomineeName;
}
public String getRelationship() {
	return relationship;
}
public void setRelationship(String relationship) {
	this.relationship = relationship;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public BigDecimal getSharePercentage() {
	return sharePercentage;
}
public void setSharePercentage(BigDecimal sharePercentage) {
	this.sharePercentage = sharePercentage;
}
public String getVerificationStatus() {
	return verificationStatus;
}
public void setVerificationStatus(String verificationStatus) {
	this.verificationStatus = verificationStatus;
}
public LocalDateTime getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
}
public LocalDateTime getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(LocalDateTime updatedDate) {
	this.updatedDate = updatedDate;
}



}
