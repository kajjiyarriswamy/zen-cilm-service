package com.zenbank.deposit_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.exception.DepositNotFoundException;
import com.zenbank.deposit_service.exception.InvalidDepositIDException;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;

@Service
public class DepositTransactionServiceImpl implements DepositTransactionService {
    
    private final DepositTransactionRepository depositTransactionRepository;

    public DepositTransactionServiceImpl(DepositTransactionRepository depositTransactionRepository) {
        this.depositTransactionRepository = depositTransactionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DepositResponse getDepositTransactionDetails(Long depositId) {
        
        if (depositId == null || depositId <= 0) {
            throw new InvalidDepositIDException("Invalid Deposit ID.");
        }
        
        DepositTransaction depositTransaction = depositTransactionRepository.findById(depositId)
                .orElseThrow(() -> new DepositNotFoundException("Deposit transaction not found."));
        
        DepositResponse response = new DepositResponse();
        response.setStatus("SUCCESS");
        response.setMessage("Deposit details retrieved successfully.");
        
        DepositResponse.DepositResponseData data = new DepositResponse.DepositResponseData();
        data.setDepositId(depositTransaction.getDepositId());
        data.setTransactionReference(depositTransaction.getTransactionReference());
        data.setCustomerId(depositTransaction.getCustomerId());
        data.setAccountId(depositTransaction.getAccountId());
        
        if (depositTransaction.getDepositType() != null) {
            data.setDepositType(depositTransaction.getDepositType().getTypeName());
        }
        if (depositTransaction.getDepositChannel() != null) {
            data.setDepositChannel(depositTransaction.getDepositChannel().getChannelName());
        }
        if (depositTransaction.getDepositReceipt() != null) {
            data.setReceiptNumber(depositTransaction.getDepositReceipt().getReceiptNumber());
        }
        
        data.setAmount(depositTransaction.getAmount());
        data.setCurrency(depositTransaction.getCurrency());
        data.setTransactionStatus(depositTransaction.getTransactionStatus());
        data.setTransactionDate(depositTransaction.getTransactionDate());
        data.setBranchName(depositTransaction.getBranchName());
        
        response.setData(data);
        return response;
    }
}