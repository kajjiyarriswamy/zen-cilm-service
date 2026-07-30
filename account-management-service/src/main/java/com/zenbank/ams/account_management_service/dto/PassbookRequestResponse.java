package com.zenbank.ams.account_management_service.dto;

public class PassbookRequestResponse {

	private String status;

	private String message;

	private String passbookRequestId;

	private String requestStatus;

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

	public String getPassbookRequestId() {
		return passbookRequestId;
	}

	public void setPassbookRequestId(String passbookRequestId) {
		this.passbookRequestId = passbookRequestId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

}
