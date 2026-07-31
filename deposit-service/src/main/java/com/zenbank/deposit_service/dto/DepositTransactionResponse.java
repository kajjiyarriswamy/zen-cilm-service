package com.zenbank.deposit_service.dto;

import java.time.LocalDateTime;

public class DepositTransactionResponse {
	
	private Long depositId;
    private String transactionReference;
    private Long customerId;
    private Long accountId;
    private String depositType;
    private String depositChannel;
    private Double amount;
    private String transactionStatus;
    private LocalDateTime transactionDate;
   
	public DepositTransactionResponse(Long depositId, String transactionReference, Long customerId, Long accountId,
			
			String depositType, String depositChannel, Double amount, String transactionStatus,
			
			LocalDateTime transactionDate) {
		
		super();
		
		this.depositId = depositId;
		this.transactionReference = transactionReference;
		this.customerId = customerId;
		this.accountId = accountId;
		this.depositType = depositType;
		this.depositChannel = depositChannel;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.transactionDate = transactionDate;
		
	}

	public DepositTransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

}
