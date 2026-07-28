package com.zenbank.deposit_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;
import com.zenbank.deposit_service.entity.DepositReceipt;
import com.zenbank.deposit_service.entity.DepositTransaction;
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
}
