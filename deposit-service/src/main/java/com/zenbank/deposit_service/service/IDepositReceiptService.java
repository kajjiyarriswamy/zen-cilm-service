package com.zenbank.deposit_service.service;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;

public interface IDepositReceiptService {
	
public DepositReceiptResponseDto createDepositReceipt(Long DepositId);

public DepositReceiptResponseDto getDepositReceipt(Long DepositId);
}
