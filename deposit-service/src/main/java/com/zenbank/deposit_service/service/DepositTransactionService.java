package com.zenbank.deposit_service.service;

import java.time.LocalDate;
import com.zenbank.deposit_service.dto.DepositSearchResponse;

public interface DepositTransactionService { 
		
	DepositSearchResponse searchByparams(Long depositId,
			String transactionReference,
			Long customerId,
			Long accountId,
			String depositType,
			String depositChannel,
			Double amount,
			String transactionStatus,
			LocalDate fromDate,
			LocalDate toDate, 
			String branchCode,
			Integer page,
			Integer size, 
			String sortBy,
			String sortDirection);
	
}
