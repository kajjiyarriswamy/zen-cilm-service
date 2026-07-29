package com.zenbank.deposit_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenbank.deposit_service.dto.UpdateDepositRequest;
import com.zenbank.deposit_service.dto.UpdateDepositResponse;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.exception.DepositNotFoundException;
import com.zenbank.deposit_service.exception.InvalidApprovalStatusException;
import com.zenbank.deposit_service.exception.TransactionAlreadyCompletedException;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;

@Service
public class UpdateDepositTransactionServiceImpl implements UpdateDepositTransactionService {

	private final DepositTransactionRepository depositTransactionRepository;

    public UpdateDepositTransactionServiceImpl(DepositTransactionRepository depositTransactionRepository) {
        this.depositTransactionRepository = depositTransactionRepository;
    }
	
	@Override
	@Transactional
	public UpdateDepositResponse getUpdateDepositResponse(Long depositId, UpdateDepositRequest request) {
		
		DepositTransaction depositTransaction = depositTransactionRepository.findById(depositId)
								.orElseThrow(()-> new DepositNotFoundException("Deposit transaction not found."));
		
		if ("COMPLETED".equalsIgnoreCase(depositTransaction.getTransactionStatus()) 
                || "SUCCESS".equalsIgnoreCase(depositTransaction.getTransactionStatus())) {
            throw new TransactionAlreadyCompletedException("Completed deposit transactions cannot be updated.");
        }
		
		if ("CANCELLED".equalsIgnoreCase(depositTransaction.getTransactionStatus())) {
            throw new IllegalStateException("Cancelled deposit transactions cannot be updated.");
        }

		String status = request.getApprovalStatus();

		boolean isValidStatus = status != null && (
		    "APPROVED".equalsIgnoreCase(status) ||
		    "REJECTED".equalsIgnoreCase(status) ||
		    "PENDING".equalsIgnoreCase(status)
		);

		if (!isValidStatus) {
		    throw new InvalidApprovalStatusException("Invalid approval status.");
		}
				
		
		depositTransaction.setRemarks(request.getRemarks());
		depositTransaction.setApprovalStatus(request.getApprovalStatus());
		depositTransaction.setApprovedBy(request.getApprovedBy());
		depositTransaction.setBranchCode(request.getBranchCode());
		depositTransaction.setBranchName(request.getBranchName());
		depositTransaction.setUpdatedDate(LocalDateTime.now());
		
		DepositTransaction savedTransaction = depositTransactionRepository.save(depositTransaction);
		
		UpdateDepositResponse response=new UpdateDepositResponse();
		UpdateDepositResponse.UpdateDepositResponseData data=new UpdateDepositResponse.UpdateDepositResponseData();
		
		response.setStatus("SUCCESS");
		response.setMessage("Deposit transaction updated successfully.");
		
		data.setDepositId(savedTransaction.getDepositId());
		data.setTransactionReference(savedTransaction.getTransactionReference());
		data.setApprovalStatus(savedTransaction.getApprovalStatus());
        data.setApprovedBy(savedTransaction.getApprovedBy());
        data.setRemarks(savedTransaction.getRemarks());
        data.setTransactionStatus(savedTransaction.getTransactionStatus());
        data.setUpdatedDate(savedTransaction.getUpdatedDate());
		
		
		response.setData(data);
		return response;
	}

}
