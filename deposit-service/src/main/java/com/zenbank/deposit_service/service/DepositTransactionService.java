package com.zenbank.deposit_service.service;

import java.time.LocalDate;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.entity.DepositTransaction;

@Service
public interface DepositTransactionService{
	
	DepositResponse getDepositTransactionDetails(Long depositId);

	DepositResponse searchByparams(Long customerId, Long accountId, String transactionReference, String depositType,
			String depositChannel, String transactionStatus, LocalDate fromDate, LocalDate toDate, String branchCode,
			Integer page, Integer size, String sortBy, String sortDirection);

	
	
}
