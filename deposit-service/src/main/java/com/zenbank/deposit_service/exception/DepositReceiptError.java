package com.zenbank.deposit_service.exception;

public class DepositReceiptError  {

	private String status;
    private String errorCode;
    private String message;
	public DepositReceiptError() {
		super();
	}
	public DepositReceiptError(String status, String errorCode, String message) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    //depositReceipt

}
