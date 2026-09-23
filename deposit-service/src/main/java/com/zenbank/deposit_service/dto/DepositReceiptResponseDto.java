package com.zenbank.deposit_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.zenbank.deposit_service.entity.DepositReceipt;
import com.zenbank.deposit_service.entity.DepositTransaction;
public class DepositReceiptResponseDto {
	
	private Long receiptId;

	private String receiptNumber;

	private Long depositId;

	private String transactionReference;

	private Long customerId;
	
	private Long accountId;
	
	private BigDecimal depositAmount;
	
	private String depositType;
	
	private String transactionStatus;
	
	private LocalDateTime generatedDate;

	public DepositReceiptResponseDto() {
		super();
	}

	public DepositReceiptResponseDto(Long receiptId, String receiptNumber, Long depositId, String transactionReference,
			Long customerId, Long accountId, BigDecimal depositAmount,
			 String depositType, String transactionStatus,
			LocalDateTime generatedDate) {
		super();
		this.receiptId = receiptId;
		this.receiptNumber = receiptNumber;
		this.depositId = depositId;
		this.transactionReference = transactionReference;
		this.customerId = customerId;
		this.accountId = accountId;
		this.depositAmount = depositAmount;
		this.depositType = depositType;
		this.transactionStatus = transactionStatus;
		this.generatedDate = generatedDate;
	}

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
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

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	 

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public LocalDateTime getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(LocalDateTime generatedDate) {
		this.generatedDate = generatedDate;
	}
	
	public static DepositReceiptResponseDto fromEntity(
			DepositReceipt receipt,
			DepositTransaction transaction) {
		
		return new DepositReceiptResponseDto(
                receipt.getReceiptId(),
                receipt.getReceiptNumber(),
                transaction.getDepositId(),
                transaction.getTransactionReference(),
                transaction.getCustomerId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getDepositType().getTypeName(),
                transaction.getTransactionStatus(),
                receipt.getGeneratedDate());
	}

}
