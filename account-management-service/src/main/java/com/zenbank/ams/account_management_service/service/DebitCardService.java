package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;

public interface DebitCardService {

   // DebitCardResponse createDebitCardRequest(DebitCardRequest requestDto);
	 DebitCardResponse createDebitCardRequest(DebitCardRequest requestDto, Long accountId);
   
    
}
