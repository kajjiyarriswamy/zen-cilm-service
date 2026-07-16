package com.zenbank.ams.account_management_service.dto;

import java.time.LocalDate;

public class PassbookRequestDetailsResponse {
	
	private String status;
	private PassbookRequestData data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PassbookRequestData getData() {
		return data;
	}
	public void setData(PassbookRequestData data) {
		this.data = data;
	}
	
	public static class PassbookRequestData{
		private String passbookRequestId;
		private String accountNumber;
		private String requestType;
		private String requestMode;
		private String deliveryMode;
		private String requestStatus;
		private String courierTrackingNumber;
		private LocalDate dispatchDate;
		private LocalDate deliveryDate;
		private String remarks;
		public String getPassbookRequestId() {
			return passbookRequestId;
		}
		public void setPassbookRequestId(String passbookRequestId) {
			this.passbookRequestId = passbookRequestId;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getRequestType() {
			return requestType;
		}
		public void setRequestType(String requestType) {
			this.requestType = requestType;
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
		public String getRequestStatus() {
			return requestStatus;
		}
		public void setRequestStatus(String requestStatus) {
			this.requestStatus = requestStatus;
		}
		public String getCourierTrackingNumber() {
			return courierTrackingNumber;
		}
		public void setCourierTrackingNumber(String courierTrackingNumber) {
			this.courierTrackingNumber = courierTrackingNumber;
		}
		public LocalDate getDispatchDate() {
			return dispatchDate;
		}
		public void setDispatchDate(LocalDate dispatchDate) {
			this.dispatchDate = dispatchDate;
		}
		public LocalDate getDeliveryDate() {
			return deliveryDate;
		}
		public void setDeliveryDate(LocalDate deliveryDate) {
			this.deliveryDate = deliveryDate;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		
		
	}

	
	}


