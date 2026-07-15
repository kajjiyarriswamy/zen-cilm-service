package com.zenbank.ams.account_management_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountLimitRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountLimitResponseDto;
import com.zenbank.ams.account_management_service.entity.AccountLimit;
import com.zenbank.ams.account_management_service.exception.AccountLimitError;
import com.zenbank.ams.account_management_service.repository.AccountLimitRepository;

@Service
public class AccountLimitServiceImpl implements IAccountLimitService {
	
	@Autowired
	private AccountLimitRepository alRepo;

	@Override
	public AccountLimitResponseDto createAccountLimit(AccountLimitRequestDto dto,Long accountId) {
		if(accountId !=0 && accountId!=null) {
			
			AccountLimit al=new AccountLimit();
			dto.setAccountId(accountId);
			
			al.setAccountId(dto.getAccountId());
			al.setCreatedBy(dto.getCreatedBy());
			al.setDailyAtmLimit(dto.getDailyAtmLimit());
			al.setDailyImpsLimit(dto.getDailyImpsLimit());
			al.setDailyUpiLimit(dto.getDailyUpiLimit());
			al.setRtgsLimit(dto.getDailyRtgsLimit());
			al.setMonthlyTransferLimit(dto.getMonthlyTransferLimit());
			
			AccountLimit acclimit=alRepo.save(al);
			return AccountLimitResponseDto.fromEntity(acclimit);
		}
		else {
		 throw new AccountLimitError("Transaction limits already configured for this account");
		}
		
	}


}
