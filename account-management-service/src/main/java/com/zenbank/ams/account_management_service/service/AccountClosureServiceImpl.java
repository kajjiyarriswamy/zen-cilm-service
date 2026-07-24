package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountClosureResponseDto;
import com.zenbank.ams.account_management_service.dto.CancelAccountClosureRequestDto;
import com.zenbank.ams.account_management_service.dto.CloseAccountRequestDto;
import com.zenbank.ams.account_management_service.dto.CloseAccountResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountClosure;
import com.zenbank.ams.account_management_service.repository.AccountClosureRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountClosureServiceImpl implements AccountClosureService{
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountClosureRepository accountClosureRepository;

	@Override
	@Transactional
	public CloseAccountResponseDto closeAccount(Long accountId, CloseAccountRequestDto request) {
		CloseAccountResponseDto response=new CloseAccountResponseDto();
		Account account=accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account Not Found."));
		
		if("CLOSED".equalsIgnoreCase(account.getAccountStatus())) {
			throw new RuntimeException("Account is Already Closed.");
		}
		if(account.getAvailableBalance()>0) {
			throw new RuntimeException("Account cannot be closed because balance is not zero.");
		}
		AccountClosure accountClosure= new AccountClosure();
		accountClosure.setAccount(account);
		accountClosure.setClosureReason(request.getClosureReason());
		accountClosure.setRemarks(request.getRemarks());
		accountClosure.setClosureStatus("CLOSED");
		accountClosure.setClosedBy("SYSTEM");
		accountClosure.setClosedDate(LocalDateTime.now());
		account.setAccountStatus("CLOSED");
		account.setUpdatedDate(LocalDate.now());
		accountClosureRepository.save(accountClosure);
		accountRepository.save(account);
		response.setStatus("SUCCESS");
		response.setMessage("Account closed successfully.");
		return response;
	}

	@Override
	@Transactional
	public AccountClosureResponseDto cancelAccountClosureRequest(Long accountId,
			CancelAccountClosureRequestDto request) {
		AccountClosureResponseDto response=new AccountClosureResponseDto();
		Account account=accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account Not Found."));
		AccountClosure accountClosure=accountClosureRepository.findByAccountAccountId(accountId).orElseThrow(()->new RuntimeException("No pending account closure request found."));
		if(!"PENDING".equalsIgnoreCase(accountClosure.getClosureStatus())) {
			throw new RuntimeException("No pending account closure request found.");
		}
		accountClosure.setCancelledBy(request.getCancelledBy());
		accountClosure.setCancelledDate(LocalDateTime.now());
		accountClosure.setCancelReason(request.getCancelReason());
		accountClosure.setClosureStatus("PENDING");
		account.setAccountStatus("ACTIVE");
		account.setUpdatedDate(LocalDate.now());
		accountClosureRepository.save(accountClosure);
		accountRepository.save(account);
		response.setStatus("SUCCESS");
		response.setMessage("Account closure request cancelled successfully.");
		response.setAccountStatus("ACTIVE");
		
		return response;
	}

}
