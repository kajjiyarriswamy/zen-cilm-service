package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.dto.CustomerAccountsResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.NumOfRecordsResponseDto;
import com.zenbank.ams.account_management_service.exception.CustomerNotFound;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountServiceI {
	
	@Autowired


	private AccountRepository accountrepository;
	
	@Override
	public AccountResponseDto accountCreate(AccountRequestDto reqdto) {
		if(reqdto.getCustomerId()!=null &&  !reqdto.getCustomerId().isBlank()) {
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
			ac.setInitialDeposit(reqdto.getInitialDeposit());
			ac.setUpdatedDate(LocalDate.now());
			Account savedAccount = accountrepository.save(ac);
			
			return AccountResponseDto.fromEntity(savedAccount);
			
		}
		else {
		 throw new CustomerNotFound("customer dont have an account......");
		}
		
	}
<<<<<<< Updated upstream



	@Override
	public List<CustomerAccountsResponseDto> getAccountsByCustomerId(String custId) {
		// TODO Auto-generated method stub
		if(!(custId ==null ||  "null".equalsIgnoreCase(custId)) && !custId.isBlank()) {
		List<Account> accountslist = accountrepository.findBycustomerIdEquals(custId);
		if(!accountslist.isEmpty()) {
		List<CustomerAccountsResponseDto> list = new LinkedList<CustomerAccountsResponseDto>();
		for(Account a : accountslist) {
			CustomerAccountsResponseDto custAcResp = new CustomerAccountsResponseDto(a.getAccountNumber(),a.getAccountType(),
					a.getAccountStatus());
			list.add(custAcResp);
			
		}
		return list;
		}
		else {
			throw  new CustomerNotFound("Their is no Customer With this Id:"+custId);
		}
		
		}
		else {
			throw  new CustomerNotFound("Please Enter correct CustomerId....!");
		}
	}



	@Override
	public  NumOfRecordsResponseDto getAccountsByParameters(String customerId, Long accountNumber, Long mobileNumber,
			String panNumber, String status, String branchCode, Integer page, Integer size) {
		// TODO Auto-generated method stub
		
		 Pageable pageable =  PageRequest.of(page,size);
		 
		List<Account> accountList =  accountrepository.findByCustomersByParams(customerId, accountNumber, mobileNumber, panNumber, status, branchCode, pageable);
		if(!accountList.isEmpty()){
			int count = accountList.size();
			NumOfRecordsResponseDto numDto = new NumOfRecordsResponseDto("Success",count,List.of("Account entities or DTOs should be there"));
			
			return numDto;
		}
		else {
			throw new CustomerNotFound("Enter Any valid customerId: , accountNumber: , mobileNumber: , panNumber: , status: , branchCode:");
		}
		
		
	
	}

}
	




=======
}
>>>>>>> Stashed changes
