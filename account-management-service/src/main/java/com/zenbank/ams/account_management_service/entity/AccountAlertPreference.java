package com.zenbank.ams.account_management_service.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "account_alert_preference")
public class AccountAlertPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long preferenceId;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private Account account;

    @Column(name = "debit_alert")
    private String debitAlert;

    @Column(name = "credit_alert")
    private String creditAlert;

    @Column(name = "low_balance_alert")
    private String lowBalanceAlert;

    @Column(name = "minimum_balance")
    private BigDecimal minimumBalance;

    @Column(name = "cheque_bounce_alert")
    private String chequeBounceAlert;

    @Column(name = "emi_due_alert")
    private String emiDueAlert;

    @Column(name = "interest_credit_alert")
    private String interestCreditAlert;

    @Column(name = "login_alert")
    private String loginAlert;

    @Column(name = "large_transaction_alert")
    private String largeTransactionAlert;

    @Column(name = "large_transaction_amount")
    private BigDecimal largeTransactionAmount;

    @Column(name = "notification_mode")
    private String notificationMode;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

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

	public String getDebitAlert() {
		return debitAlert;
	}

	public void setDebitAlert(String debitAlert) {
		this.debitAlert = debitAlert;
	}

	public String getCreditAlert() {
		return creditAlert;
	}

	public void setCreditAlert(String creditAlert) {
		this.creditAlert = creditAlert;
	}

	public String getLowBalanceAlert() {
		return lowBalanceAlert;
	}

	public void setLowBalanceAlert(String lowBalanceAlert) {
		this.lowBalanceAlert = lowBalanceAlert;
	}

	public BigDecimal getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(BigDecimal minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getChequeBounceAlert() {
		return chequeBounceAlert;
	}

	public void setChequeBounceAlert(String chequeBounceAlert) {
		this.chequeBounceAlert = chequeBounceAlert;
	}

	public String getEmiDueAlert() {
		return emiDueAlert;
	}

	public void setEmiDueAlert(String emiDueAlert) {
		this.emiDueAlert = emiDueAlert;
	}

	public String getInterestCreditAlert() {
		return interestCreditAlert;
	}

	public void setInterestCreditAlert(String interestCreditAlert) {
		this.interestCreditAlert = interestCreditAlert;
	}

	public String getLoginAlert() {
		return loginAlert;
	}

	public void setLoginAlert(String loginAlert) {
		this.loginAlert = loginAlert;
	}

	public String getLargeTransactionAlert() {
		return largeTransactionAlert;
	}

	public void setLargeTransactionAlert(String largeTransactionAlert) {
		this.largeTransactionAlert = largeTransactionAlert;
	}

	public BigDecimal getLargeTransactionAmount() {
		return largeTransactionAmount;
	}

	public void setLargeTransactionAmount(BigDecimal largeTransactionAmount) {
		this.largeTransactionAmount = largeTransactionAmount;
	}

	public String getNotificationMode() {
		return notificationMode;
	}

	public void setNotificationMode(String notificationMode) {
		this.notificationMode = notificationMode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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