package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountLimitRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountLimitResponseDto;
import com.zenbank.ams.account_management_service.dto.GetAccountLimitResponseDto;
import com.zenbank.ams.account_management_service.dto.UpdateAccountLimitResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountLimit;
import com.zenbank.ams.account_management_service.exception.AccountLimitError;
import com.zenbank.ams.account_management_service.exception.AccountLimitNotFound;
import com.zenbank.ams.account_management_service.repository.AccountLimitRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountLimitServiceImpl implements IAccountLimitService {
	
	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private AccountLimitRepository acclimitRepo;

	@Override
	public AccountLimitResponseDto createAccountLimit(AccountLimitRequestDto dto, Long accountId) {

	    if(accountId != null && accountId != 0) {

	        Account account = accountRepo.findById(accountId)
	                .orElseThrow(() -> new AccountLimitError("Account not found"));

	        AccountLimit al = new AccountLimit();

	        al.setAccount(account);

	        al.setCreatedBy(dto.getCreatedBy());

	        al.setDailyAtmLimit(dto.getDailyAtmLimit());
	        al.setDailyUpiLimit(dto.getDailyUpiLimit());
	        al.setDailyImpsLimit(dto.getDailyImpsLimit());
	        al.setDailyNeftLimit(dto.getDailyNeftLimit());
	        al.setRtgsLimit(dto.getDailyRtgsLimit());
	        al.setMonthlyTransferLimit(dto.getMonthlyTransferLimit());

	        al.setStatus(dto.getStatus());

	        al.setCreatedDate(LocalDateTime.now());
	        al.setUpdatedDate(LocalDateTime.now());

	        AccountLimit saved = acclimitRepo.save(al);

	        return AccountLimitResponseDto.fromEntity(saved);
	    }

	    throw new AccountLimitError("Transaction limits already configured for this account");
	}

	
	public UpdateAccountLimitResponseDto updateAccountLimit(AccountLimitRequestDto dto, Long accountId) {

	    AccountLimit accountLimit = acclimitRepo.findByAccountAccountId(accountId)
	         .orElseThrow(()->new AccountLimitNotFound("Account limit not found"));
	    

	    accountLimit.setDailyAtmLimit(dto.getDailyAtmLimit());
	    accountLimit.setDailyUpiLimit(dto.getDailyUpiLimit());
	    accountLimit.setDailyImpsLimit(dto.getDailyImpsLimit());
	    accountLimit.setDailyNeftLimit(dto.getDailyNeftLimit());
	    accountLimit.setRtgsLimit(dto.getDailyRtgsLimit());
	    accountLimit.setMonthlyTransferLimit(dto.getMonthlyTransferLimit());

	    acclimitRepo.save(accountLimit);

		
		  return UpdateAccountLimitResponseDto.fromEntity( "success",
		  "Transaction limits updated successfully.");
		 
	   // return new UpdateAccountLimitResponseDto("success","Transaction limits updated successfully.");
	}

	
		@Override
		public GetAccountLimitResponseDto getAccountLimit(Long accountId) {
			AccountLimit accountLimit=acclimitRepo.findByAccountAccountId(accountId)
					.orElseThrow(()->new AccountLimitNotFound("Account limit not found"));
			
			return GetAccountLimitResponseDto.fromEntity(accountLimit);
		}
}