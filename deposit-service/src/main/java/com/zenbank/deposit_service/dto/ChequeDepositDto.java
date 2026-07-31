package com.zenbank.deposit_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ChequeDepositDto {
	
	private Long chequeDepositId;
    private Long depositId;
    private String chequeNumber;
    private Long customerId;
    private Long accountId;
    private BigDecimal chequeAmount;
    private String issuingBank;
    private String chequeStatus;
    private String transactionStatus;
    
	public ChequeDepositDto() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public ChequeDepositDto(Long chequeDepositId, Long depositId, String chequeNumber, Long customerId, Long accountId,
			
			BigDecimal chequeAmount, String issuingBank, String chequeStatus, String transactionStatus,
			
			LocalDate depositDate) {
		
		super();
		
		this.chequeDepositId = chequeDepositId;
		this.depositId = depositId;
		this.chequeNumber = chequeNumber;
		this.customerId = customerId;
		this.accountId = accountId;
		this.chequeAmount = chequeAmount;
		this.issuingBank = issuingBank;
		this.chequeStatus = chequeStatus;
		this.transactionStatus = transactionStatus;
	}

	public Long getChequeDepositId() {
		return chequeDepositId;
	}

	public void setChequeDepositId(Long chequeDepositId) {
		this.chequeDepositId = chequeDepositId;
	}

	public Long getDepositId() {
		return depositId;
	}

	public void setDepositId(Long depositId) {
		this.depositId = depositId;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
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

	public BigDecimal getChequeAmount() {
		return chequeAmount;
	}

	public void setChequeAmount(BigDecimal chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
