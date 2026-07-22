package com.zenbank.ams.account_management_service.dto;

public class DebitCardResponse {

	private String status;
	private String message;
	private String debitCardRequestId;
	private String cardStatus;

	public DebitCardResponse() {

	}

	public DebitCardResponse(String status, String message, String debitCardRequestId, String cardStatus) {
		super();
		this.status = status;
		this.message = message;
		this.debitCardRequestId = debitCardRequestId;
		this.cardStatus = cardStatus;
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

	public String getDebitCardRequestId() {
		return debitCardRequestId;
	}

	public void setDebitCardRequestId(String debitCardRequestId) {
		this.debitCardRequestId = debitCardRequestId;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Override
	public String toString() {
		return "DebitCardResponseDto [status=" + status + ", message=" + message + ", debitCardRequestId="
				+ debitCardRequestId + ", cardStatus=" + cardStatus + "]";
	}

}
