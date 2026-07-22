package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.dto.BlockedRequestDto;
import com.zenbank.ams.account_management_service.dto.BlockedResponseDto;
import com.zenbank.ams.account_management_service.dto.CustomerAccountsResponseDto;
import com.zenbank.ams.account_management_service.dto.UnblockRequestDto;
import com.zenbank.ams.account_management_service.dto.UnblockedResponseDto;
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
		if (reqdto.getCustomerId() != null && !reqdto.getCustomerId().isBlank()) {
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

	@Override
	public BlockedResponseDto accountBlockingById(Long accountId,BlockedRequestDto blockeddto) {
		// TODO Auto-generated method stub
		Optional<Account> opt = accountrepository.findById(accountId);
		if(opt.isPresent() && blockeddto.getReason().equalsIgnoreCase("Fraud Detection")) {
			Account acc = opt.get();
			acc.setAccountStatus("BLOCKED");
			Account ac = accountrepository.save(acc);
			if(ac.getAccountId()>0) {
			return new BlockedResponseDto("SUCCESS","Account blocked successfully.");
			}
			else {
				throw new CustomerNotFound("Account is in Active ");
			}
		}
		
		throw new CustomerNotFound("Customer doesnot exit with this Id"+" "+accountId);
	}

	@Override
	public UnblockedResponseDto unblockingAccountById(Long accountId, UnblockRequestDto unblockdto) {
		// TODO Auto-generated method stub
		
		Optional<Account> opt = accountrepository.findById(accountId);
		if(opt.isPresent()) {
			Account acc = opt.get();
			if(acc.getAccountStatus().equalsIgnoreCase("Blocked") && unblockdto.getReason().equalsIgnoreCase("Fraud Investigation Completed")) {
				acc.setAccountStatus("ACTIVE");
				Long aid= accountrepository.save(acc).getAccountId();
				if(aid>0) {
					return new UnblockedResponseDto("SUCCESS","Account unblocked successfully");
				}
				else {
					throw new CustomerNotFound("No Accounts Found With this AccountId.....");
				}
				
			}
			else {
				throw new CustomerNotFound("Account is Already Unblocked...");
			}
		}
		
		throw new CustomerNotFound("Enter valid account Id..");
	}
	
	

}
