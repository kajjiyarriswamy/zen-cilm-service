package com.zenbank.ams.account_management_service.dto;

import java.util.List;

import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse.PassbookRequestData;

public class SearchPassbookRequestResponse {
	private String status;

	private int page;

	private int size;

	private long totalRecords;

	private List<PassbookRequestData> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<PassbookRequestData> getData() {
		return data;
	}

	public void setData(List<PassbookRequestData> data) {
		this.data = data;
	}
	
	public static class PassbookRequestData {

        private String passbookRequestId;

        private String accountNumber;

        private String requestType;

        private String requestStatus;

        private String deliveryMode;

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

		public String getRequestStatus() {
			return requestStatus;
		}

		public void setRequestStatus(String requestStatus) {
			this.requestStatus = requestStatus;
		}

		public String getDeliveryMode() {
			return deliveryMode;
		}

		public void setDeliveryMode(String deliveryMode) {
			this.deliveryMode = deliveryMode;
		}
        
	}

}
