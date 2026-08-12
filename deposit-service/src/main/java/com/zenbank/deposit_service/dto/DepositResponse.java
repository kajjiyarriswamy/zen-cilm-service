package com.zenbank.deposit_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DepositResponse {
	
	private String status;
	private String message; 
	private DepositResponseData data;
	
	public DepositResponse() {
	}

	public DepositResponse(String status, String message, DepositResponseData data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
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

	public DepositResponseData getData() {
		return data;
	}

	public void setData(DepositResponseData data) {
		this.data = data;
	}
	
	public static class DepositResponseData {
		private Long depositId;
		private String transactionReference;
		private Long customerId;
		private Long accountId;
		private String depositType;
		private String depositChannel;
		private BigDecimal depositAmount;
		private String currency;
		private String transactionStatus;
		private LocalDateTime transactionDate;
		private Double availableBalance;
		private String receiptNumber;
		
		public DepositResponseData() {
		}

		public DepositResponseData(Long depositId, String transactionReference, Long customerId, Long accountId,
				String depositType, String depositChannel, BigDecimal depositAmount, String currency, String transactionStatus,
				LocalDateTime transactionDate, Double availableBalance, String receiptNumber) {
			super();
			this.depositId = depositId;
			this.transactionReference = transactionReference;
			this.customerId = customerId;
			this.accountId = accountId;
			this.depositAmount = depositAmount;
			this.currency = currency;
			this.depositType = depositType;
			this.depositChannel = depositChannel;
			this.transactionStatus = transactionStatus;
			this.transactionDate = transactionDate;
			this.availableBalance = availableBalance;
			this.receiptNumber = receiptNumber;
		}

		public Long getDepositId() {
			return depositId;
		}

		public void setDepositId(Long depositId) {
			this.depositId = depositId;
		}

		public String getTransactionReference() {
			return transactionReference;
		}

		public void setTransactionReference(String transactionReference) {
			this.transactionReference = transactionReference;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}

		public String getDepositType() {
			return depositType;
		}

		public void setDepositType(String depositType) {
			this.depositType = depositType;
		}

		public String getDepositChannel() {
			return depositChannel;
		}

		public void setDepositChannel(String depositChannel) {
			this.depositChannel = depositChannel;
		}

		public BigDecimal getDepositAmount() {
			return depositAmount;
		}

		public void setDepositAmount(BigDecimal depositAmount) {
			this.depositAmount = depositAmount;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getTransactionStatus() {
			return transactionStatus;
		}

		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		public LocalDateTime getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(LocalDateTime transactionDate) {
			this.transactionDate = transactionDate;
		}

		public Double getAvailableBalance() {
			return availableBalance;
		}

		public void setAvailableBalance(Double availableBalance) {
			this.availableBalance = availableBalance;
		}

		public String getReceiptNumber() {
			return receiptNumber;
		}

		public void setReceiptNumber(String receiptNumber) {
			this.receiptNumber = receiptNumber;
		}
	}
}
