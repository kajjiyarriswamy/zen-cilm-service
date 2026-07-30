package com.zenbank.deposit_service.service;

import com.zenbank.deposit_service.dto.UpdateDepositRequest;
import com.zenbank.deposit_service.dto.UpdateDepositResponse;

public interface UpdateDepositTransactionService {
	
	UpdateDepositResponse getUpdateDepositResponse(Long depositId, UpdateDepositRequest request);

}
