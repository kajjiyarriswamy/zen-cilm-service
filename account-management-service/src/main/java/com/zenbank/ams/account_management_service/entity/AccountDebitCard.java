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
@Table(name = "account_debit_card")
public class AccountDebitCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "debit_card_id")
	private Long debitCardId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "card_variant")
	private String cardVariant;

	@Column(name = "card_holder_name")
	private String cardHolderName;

	@Column(name = "issue_type")
	private String issueType;

	@Column(name = "request_mode")
	private String requestMode;

	@Column(name = "delivery_mode")
	private String deliveryMode;

	@Column(name = "dispatch_address")
	private String dispatchAddress;

	@Column(name = "card_status")
	private String cardStatus;

	@Column(name = "expiry_month")
	private Integer expiryMonth;

	@Column(name = "expiry_year")
	private Integer expiryYear;

	@Column(name = "tracking_number")
	private String trackingNumber;

	@Column(name = "dispatched_date")
	private LocalDate dispatchedDate;

	@Column(name = "activated_date")
	private LocalDate activatedDate;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public AccountDebitCard() {

	}

	public AccountDebitCard(Long debitCardId, Account account, String customerId, String accountNumber, String cardNumber,
			String cardType, String cardVariant, String cardHolderName, String issueType, String requestMode,
			String deliveryMode, String dispatchAddress, String cardStatus, Integer expiryMonth, Integer expiryYear,
			String trackingNumber, LocalDate dispatchedDate, LocalDate activatedDate, String remarks, String createdBy,
			LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate) {
		super();
		this.debitCardId = debitCardId;
		this.account = account;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardVariant = cardVariant;
		this.cardHolderName = cardHolderName;
		this.issueType = issueType;
		this.requestMode = requestMode;
		this.deliveryMode = deliveryMode;
		this.dispatchAddress = dispatchAddress;
		this.cardStatus = cardStatus;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.trackingNumber = trackingNumber;
		this.dispatchedDate = dispatchedDate;
		this.activatedDate = activatedDate;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Long getDebitCardId() {
		return debitCardId;
	}

	public void setDebitCardId(Long debitCardId) {
		this.debitCardId = debitCardId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardVariant() {
		return cardVariant;
	}

	public void setCardVariant(String cardVariant) {
		this.cardVariant = cardVariant;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getRequestMode() {
		return requestMode;
	}

	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getDispatchAddress() {
		return dispatchAddress;
	}

	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public LocalDate getDispatchedDate() {
		return dispatchedDate;
	}

	public void setDispatchedDate(LocalDate dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public LocalDate getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(LocalDate activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
