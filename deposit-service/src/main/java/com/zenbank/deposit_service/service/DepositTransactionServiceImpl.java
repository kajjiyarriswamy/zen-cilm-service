package com.zenbank.deposit_service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositSearchResponse;
import com.zenbank.deposit_service.dto.DepositTransactionResponse;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.exception.InvalidDateRangeException;
import com.zenbank.deposit_service.exception.InvalidSearchParameterException;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;

@Service
public class DepositTransactionServiceImpl implements DepositTransactionService {
	
    @Autowired
    private  DepositTransactionRepository depositTransactionRepository;

	@Override
	public DepositSearchResponse searchByparams(Long depositId,
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
			String sortDirection) {
		
		 if (fromDate != null && toDate != null && fromDate.isAfter(toDate)) {
		        throw new InvalidDateRangeException();
		    }
		
		if (depositType != null &&
	            !(depositType.equalsIgnoreCase("CASH")
	            || depositType.equalsIgnoreCase("CHEQUE")
	            || depositType.equalsIgnoreCase("UPI"))) {
	        throw new InvalidSearchParameterException();
	    }

	    if (depositChannel != null &&
	            !(depositChannel.equalsIgnoreCase("BRANCH")
	            || depositChannel.equalsIgnoreCase("ATM")
	            || depositChannel.equalsIgnoreCase("MOBILE"))) {
	        throw new InvalidSearchParameterException();
	    }

	    if (transactionStatus != null &&
	            !(transactionStatus.equalsIgnoreCase("SUCCESS")
	            || transactionStatus.equalsIgnoreCase("PENDING")
	            || transactionStatus.equalsIgnoreCase("FAILED"))) {
	        throw new InvalidSearchParameterException();
	    }
		      
		Pageable pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.fromString(sortDirection),sortBy));
		Page<DepositTransaction> transactions=null;
	
		 transactions = depositTransactionRepository.searchDeposits(depositId,
				transactionReference,
				customerId,
				accountId,
				depositType,
			    depositChannel,
			    amount,
				transactionStatus, 
				fromDate, 
				toDate, 
				branchCode,
				pageable );
		
		List<DepositTransactionResponse> depositList = new ArrayList<>();
		
		for(DepositTransaction deposit: transactions.getContent()) {
			
			DepositTransactionResponse response = new DepositTransactionResponse();
			
			BeanUtils.copyProperties(deposit, response);
			
			depositList.add(response);
			
		}
		
		DepositSearchResponse searchResponse = new DepositSearchResponse();
		
		searchResponse.setTotalrecords(transactions.getTotalElements());
		searchResponse.setPage(transactions.getNumber());
		searchResponse.setSize(transactions.getSize());
		searchResponse.setDeposits(depositList);
			
		return searchResponse;
		
	}   
	
}

