package com.zenbank.deposit_service.service;

import com.zenbank.deposit_service.dto.DepositResponse;

public interface DepositTransactionService{
	
	DepositResponse getDepositTransactionDetails(Long depositId);

}
