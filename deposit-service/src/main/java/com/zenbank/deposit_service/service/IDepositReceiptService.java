package com.zenbank.deposit_service.service;

import java.io.IOException;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;

public interface IDepositReceiptService {
	

    DepositReceiptResponseDto createDepositReceipt(Long depositId) throws Exception;

    byte[] downloadReceipt(Long depositId) throws IOException;
}
