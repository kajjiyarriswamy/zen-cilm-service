package com.zenbank.deposit_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
																		//DepositReceipt
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;
import com.zenbank.deposit_service.entity.DepositReceipt;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.exception.DepositNotFoundException;
import com.zenbank.deposit_service.exception.DepositReceiptNotFound;
import com.zenbank.deposit_service.exception.DepositTransactionFailedException;
import com.zenbank.deposit_service.exception.ReceiptAlreadyGeneratedException;
import com.zenbank.deposit_service.repository.DepositReceiptRepository;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;

@Service
public class DepositReceiptServiceImpl implements IDepositReceiptService {
	
	@Autowired
	private DepositReceiptRepository depositReceiptRepository;
	
	@Autowired
	private DepositTransactionRepository depositTransactionRepository;

	@Override
	public DepositReceiptResponseDto createDepositReceipt(Long DepositId) {
		
	DepositTransaction transaction=depositTransactionRepository.findById(DepositId)
			.orElseThrow(()->
					new DepositReceiptNotFound("Deposit transaction Not Found. "));
		
	if(!"SUCCESS".equalsIgnoreCase(transaction.getTransactionStatus())) {
		throw new DepositTransactionFailedException("Receipt can be generated only for successful transactions. ") ;
	}
	
	if(depositTransactionRepository.findById(DepositId).isPresent()) {
		throw new ReceiptAlreadyGeneratedException("Receipt already generated for this transaction");
	}
	
	 String receiptNumber = generateReceiptNumber(transaction.getDepositId());
	
	DepositReceipt receipt = new DepositReceipt();
	transaction.setDepositId(transaction.getDepositId());
    receipt.setReceiptNumber(receiptNumber);
    receipt.setGeneratedDate(LocalDateTime.now());
    
    receipt.setContent("Deposit Receipt Generated Successfully");
    
    DepositReceipt savedReceipt = depositReceiptRepository.save(receipt);
	return  DepositReceiptResponseDto.fromEntity(savedReceipt, transaction);
	}

	private String generateReceiptNumber(Long depositId) {

        String date = LocalDate.now()
                .format(DateTimeFormatter.BASIC_ISO_DATE);

        return "RCP" + date + String.format("%04d", depositId);
    }
	@Override
	public DepositReceiptResponseDto getDepositReceipt(Long depositId) {

	    // Step 1: Validate Deposit Transaction
	    DepositTransaction transaction = depositTransactionRepository.findById(depositId)
	            .orElseThrow(() ->
	                    new DepositNotFoundException("Deposit transaction not found."));

	    // Step 2: Get Receipt from Transaction
	    DepositReceipt receipt = transaction.getDepositReceipt();

	    if (receipt == null) {
	        throw new DepositReceiptNotFound("Receipt has not been generated.");
	    }

	    // Step 3: Check Receipt Content
	    if (receipt.getContent() == null || receipt.getContent().isBlank()) {
	        throw new DepositReceiptNotFound("Receipt content not available.");
	    }

	    // Step 4: Map Entity to Response DTO
	    DepositReceiptResponseDto response = new DepositReceiptResponseDto();

	    response.setReceiptId(receipt.getReceiptId());
	    response.setReceiptNumber(receipt.getReceiptNumber());
	    response.setDepositId(transaction.getDepositId());
	    response.setTransactionReference(transaction.getTransactionReference());
	    response.setCustomerId(transaction.getCustomerId());
	    response.setAccountId(transaction.getAccountId());
	    response.setDepositAmount(transaction.getAmount());
	    response.setDepositType(transaction.getDepositType().getTypeName());
	    response.setTransactionStatus(transaction.getTransactionStatus());
	    response.setGeneratedDate(receipt.getGeneratedDate());

	    return response;
	}
}
