package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountServiceI {
	
	@Autowired
	private AccountRepository accountrepository;
	
	
	public AccountResponseDto accountCreate(AccountRequestDto reqdto) {
		if(reqdto.getCustomerId()!=null ) {
			Account ac = new Account();
			ac.setAccountNumber(reqdto.getAccountNumber());
			ac.setAccountStatus(reqdto.getAccountStatus());
			ac.setAccountType(reqdto.getAccountType());
			ac.setAvailableBalance(reqdto.getAvailableBalance());
			ac.setBranchCode(reqdto.getBranchCode());
			ac.setCreatedBy(reqdto.getCreatedBy());
			ac.setCreatedDate(LocalDate.now());
			ac.setCurrency(reqdto.getCurrency());
			ac.setCustomerId(reqdto.getCustomerId());
			ac.setIfscCode(reqdto.getIfscCode());
			ac.setLedgerBalance(reqdto.getLedgerBalance());
			ac.setOpenedDate(LocalDate.now());
			ac.setOpeningBalance(reqdto.getOpeningBalance());
			ac.setUpdatedDate(LocalDate.now());
			Account savedAccount = accountrepository.save(ac);
			
			return AccountResponseDto.fromEntity(savedAccount);
			
		}
		else {
		 throw new IllegalArgumentException("customer dont have an account......");
		}
		
	}

}
