package com.zenbank.ams.account_management_service.dto;

public class DebitCardResponseDto {

    private Long debitCardId;
    private String accountNumber;
    private String cardNumber;
    private String cardType;
    private String cardVariant;
    private String cardHolderName;
    private String cardStatus;
    private Integer expiryMonth;
    private Integer expiryYear;
    private String deliveryMode;
    private String trackingNumber;
	public Long getDebitCardId() {
		return debitCardId;
	}
	public void setDebitCardId(Long debitCardId) {
		this.debitCardId = debitCardId;
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
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
    
    

}