package com.zenbank.ams.account_management_service.dto;



	import java.math.BigDecimal;

	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.Pattern;

	public class CreateAccountAlertPreferenceRequest {

	    private String debitAlert;

	    private String creditAlert;

	    private String lowBalanceAlert;

	    private BigDecimal minimumBalance;

	    private String chequeBounceAlert;

	    private String emiDueAlert;

	    private String interestCreditAlert;

	    private String loginAlert;

	    private String largeTransactionAlert;

	    private BigDecimal largeTransactionAmount;

	    @NotBlank
	    private String notificationMode;

	    @Pattern(regexp="^[6-9][0-9]{9}$")
	    private String mobileNumber;

	    @Email
	    private String email;

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
	    

	   
	}


