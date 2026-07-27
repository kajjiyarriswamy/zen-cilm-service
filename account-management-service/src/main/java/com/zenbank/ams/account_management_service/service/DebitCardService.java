package com.zenbank.ams.account_management_service.service;

import java.util.Map;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;
import com.zenbank.ams.account_management_service.dto.DebitCardResponseDto;
import com.zenbank.ams.account_management_service.dto.DebitCardUpdateRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardUpdateResponse;

public interface DebitCardService {

   // DebitCardResponse createDebitCardRequest(DebitCardRequest requestDto);
	 DebitCardResponse createDebitCardRequest(DebitCardRequest requestDto, Long accountId);
	 
	 DebitCardResponseDto getDebitCardByAccountIdAndDebitCardId(Long accountId, Long debitCardId);
	 DebitCardUpdateResponse updateDebitCardRequest(
		        Long accountId,
		        Long debitCardId,
		        DebitCardUpdateRequest request);
	 
	 Map<String, Object> searchDebitCards(
		        String accountNumber,
		        String cardType,
		        String cardStatus,
		        String issueType,
		        int page,
		        int size);


	 
	
   
    
}
