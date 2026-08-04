package com.zenbank.deposit_service.service;

import com.zenbank.deposit_service.dto.DepositStatusHistoryGetApiResponse;
import com.zenbank.deposit_service.dto.DepositStatusHistoryRequest;
import com.zenbank.deposit_service.dto.DepositStatusHistoryResponse;

public interface DepositStatusHistoryService {

    DepositStatusHistoryResponse createStatusHistory(DepositStatusHistoryRequest request);
    
    DepositStatusHistoryGetApiResponse getStatusHistoryByDepositId(Long depositId);


}