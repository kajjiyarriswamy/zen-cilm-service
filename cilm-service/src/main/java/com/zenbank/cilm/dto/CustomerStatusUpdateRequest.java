package com.zenbank.cilm.dto;

import com.zenbank.cilm.Enum.CustomerStatus;

public class CustomerStatusUpdateRequest {
	 private CustomerStatus status;

	    public CustomerStatus getStatus() {
	        return status;
	    }

	    public void setStatus(CustomerStatus status) {
	        this.status = status;
	    }

}
