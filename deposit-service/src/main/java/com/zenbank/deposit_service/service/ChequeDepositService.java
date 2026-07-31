package com.zenbank.deposit_service.service;

import java.time.LocalDate;

import com.zenbank.deposit_service.dto.ChequeDepositSearchResponse;

public interface ChequeDepositService {
	
	ChequeDepositSearchResponse searchChequeDeposit(Long chequeDepositId,
			String chequeNumber,
			Long customerId,
			Long account,
			String issuingBank,
			String ifscCode,
			String chequeStatus,
			String transactionaStatus,
			LocalDate fromDate,
			LocalDate toDate,
			Integer page,
			Integer size,
			String sortBy,
			String sortDirection );

}
