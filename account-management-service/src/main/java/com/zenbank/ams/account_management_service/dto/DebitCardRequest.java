package com.zenbank.ams.account_management_service.dto;



public class DebitCardRequest {
	 private String customerId;
	    private String accountNumber;
	    private String cardNumber;
	    private String cardType;
	    private String cardVariant;
	    private String cardHolderName;
	    private String issueType;
	    private String requestMode;
	    private String deliveryMode;
	    private DispatchAddress dispatchAddress;
	    private String cardStatus;
	    private Integer expiryMonth;
	    private Integer expiryYear;
	    private String trackingNumber;
		private String remarks;
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
		public DispatchAddress getDispatchAddress() {
			return dispatchAddress;
		}
		public void setDispatchAddress(DispatchAddress dispatchAddress) {
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
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		
		
}