package com.zenbank.deposit_service.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.exception.DepositNotFoundException;
import com.zenbank.deposit_service.exception.InvalidDepositIDException;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;
import com.zenbank.deposit_service.repository.DepositTypeRepository;


@Service
public class DepositTransactionServiceImpl implements DepositTransactionService {
	
	private final DepositTransactionRepository depositTransactionRepository;
	private final DepositTypeRepository depositTypeRepository;
//	private final DepositReceiptRepository depositReceiptRepository;
	

	public DepositTransactionServiceImpl(DepositTransactionRepository depositTransactionRepository,
			DepositTypeRepository depositTypeRepository) {		//DepositReceiptRepository depositReceiptRepository
		super();
		this.depositTransactionRepository = depositTransactionRepository;
		this.depositTypeRepository = depositTypeRepository;
//		this.depositReceiptRepository = depositReceiptRepository;
	}


	@Override
	public DepositResponse getDepositTransactionDetails(Long depositId) {
		
		if(depositId == null || depositId <= 0) {
			throw new InvalidDepositIDException("Invalid Deposit ID.");
		}
		
		DepositTransaction depositTransaction=depositTransactionRepository.findById(depositId).orElseThrow(() -> new DepositNotFoundException("Deposit transaction not found."));
		
		DepositResponse response=new DepositResponse();
		
		response.setStatus("SUCCESS");
		response.setMessage("Deposit details retrieved successfully.");;
		
		DepositResponse.DepositResponseData data= new DepositResponse.DepositResponseData();
		data.setDepositId(depositTransaction.getDepositId());
		data.setTransactionReference(depositTransaction.getTransactionReference());
		data.setCustomerId(depositTransaction.getCustomerId());
		data.setAccountId(depositTransaction.getAccountId());
		data.setDepositType(depositTransaction.getDepositType().getTypeName());
		data.setDepositChannel(depositTransaction.getDepositChannel().getChannelName());
		data.setAmount(depositTransaction.getAmount());
		data.setCurrency(depositTransaction.getCurrency());
		data.setTransactionStatus(depositTransaction.getTransactionStatus());
		data.setTransactionDate(depositTransaction.getTransactionDate());
		data.setBranchName(depositTransaction.getBranchName());
//		data.setReceiptNumber(depositTransaction.getReceiptNumber());
		
		response.setData(data);
		return response;
	}


	@Override
	public DepositResponse searchByparams(Long customerId, Long accountId, String transactionReference,
			String depositType, String depositChannel, String transactionStatus, LocalDate fromDate, LocalDate toDate,
			String branchCode, Integer page, Integer size, String sortBy, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}

//If you later map entities outside the transactional context, you'll get a LazyInitializationException
//@Transactional(readOnly=true)