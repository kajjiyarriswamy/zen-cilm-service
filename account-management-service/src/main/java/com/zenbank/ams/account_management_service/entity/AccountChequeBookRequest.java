package com.zenbank.ams.account_management_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "account_cheque_book")
public class AccountChequeBookRequest {

	@Id
	@SequenceGenerator(name = "cheque_book_seq", sequenceName = "account_cheque_book_id", initialValue = 100001, allocationSize = 1)
	@GeneratedValue(generator = "cheque_book_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "cheque_book_id", nullable = false, updatable = false)
	private long chequeBookId;

	@Column(name = "account_id", nullable = false, updatable = false)
	private long accountId;

	@Column(name = "customer_id", nullable = false, updatable = false)
	private String customerId;

	@Column(name = "account_number", nullable = false, updatable = false, length = 20)
	private String accountNumber;

	@Column(name = "cheque_book_type", nullable = false, length = 30)
	private String chequeBookType;

	@Column(name = "leaves_count", nullable = false)
	private int leavesCount;

	@Column(name = "request_mode", nullable = false, length = 20)
	private String requestMode;

	@Column(name = "delivery_mode", nullable = false, length = 20)
	private String deliveryMode;

	@Column(name = "delivery_address", length = 500)
	private String deliveryAddress;

	@Column(name = "request_status", nullable = false, length = 30)
	private String requestStatus;

	@Column(name = "tracking_number", length = 100)
	private String trackingNumber;

	@Column(name = "dispatched_date")
	private LocalDate dispatchedDate;

	@Column(name = "delivered_date")
	private LocalDate deliveredDate;

	@Column(name = "remarks", length = 500)
	private String remarks;

	@Column(name = "created_by", nullable = false, length = 50)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by", length = 50)
	private String updatedBy;

	@Column(name = "updated_date", nullable = false)
	private LocalDateTime updatedDate;

	public AccountChequeBookRequest() {
		super();
	}

	public AccountChequeBookRequest(long chequeBookId, long accountId, String customerId, String accountNumber,
			String chequeBookType, int leavesCount, String requestMode, String deliveryMode, String deliveryAddress,
			String requestStatus, String trackingNumber, LocalDate dispatchedDate, LocalDate deliveredDate,
			String remarks, String createdBy, LocalDateTime createdDate, String updatedBy,
			LocalDateTime updatedDate) {
		super();
		this.chequeBookId = chequeBookId;
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.chequeBookType = chequeBookType;
		this.leavesCount = leavesCount;
		this.requestMode = requestMode;
		this.deliveryMode = deliveryMode;
		this.deliveryAddress = deliveryAddress;
		this.requestStatus = requestStatus;
		this.trackingNumber = trackingNumber;
		this.dispatchedDate = dispatchedDate;
		this.deliveredDate = deliveredDate;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public long getChequeBookId() {
		return chequeBookId;
	}

	public void setChequeBookId(long chequeBookId) {
		this.chequeBookId = chequeBookId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
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

	public String getChequeBookType() {
		return chequeBookType;
	}

	public void setChequeBookType(String chequeBookType) {
		this.chequeBookType = chequeBookType;
	}

	public int getLeavesCount() {
		return leavesCount;
	}

	public void setLeavesCount(int leavesCount) {
		this.leavesCount = leavesCount;
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

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
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

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
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
