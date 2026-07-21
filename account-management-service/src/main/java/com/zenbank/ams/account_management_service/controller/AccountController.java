package com.zenbank.ams.account_management_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.dto.BlockedRequestDto;
import com.zenbank.ams.account_management_service.dto.BlockedResponseDto;
import com.zenbank.ams.account_management_service.dto.CustomerAccountsResponseDto;
import com.zenbank.ams.account_management_service.entity.NumOfRecordsResponseDto;
import com.zenbank.ams.account_management_service.service.AccountServiceI;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtility;


@RestController
@RequestMapping("/api/v1")
public class AccountController {
	@Autowired
	private AccountServiceI accountservice;
	
	
	@PostMapping("/accounts")
	public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountRequestDto requestDto ){
		 AccountResponseDto responsedto = accountservice.accountCreate(requestDto);
	     return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtility.accountCreated(responsedto));
		 
	}
	
	
	@GetMapping("/customers/{customerId}/accounts")
	public ResponseEntity<Map<String, Object>> accountsByCustomerId(@PathVariable String customerId){
		 List<CustomerAccountsResponseDto>  responsedto = accountservice.getAccountsByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.FOUND).body(ApiResponseUtility.getAccountsByCustomerId(customerId, responsedto));
		
	}
	
	

	
	
	
	
	
	@GetMapping("/accounts/search")
	public ResponseEntity<NumOfRecordsResponseDto> searchAccountsByPhoneNum(@RequestParam(required =false) String customerId,
			@RequestParam(required = false) Long accountNumber,
			@RequestParam(required = false) Long mobileNumber,
			@RequestParam(required = false) String panNumber,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String branchCode,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size
			
			){
		NumOfRecordsResponseDto numRecordsResDto = accountservice.getAccountsByParameters(customerId,accountNumber,
				mobileNumber,panNumber,status,branchCode,page,size);
		
		return new ResponseEntity<NumOfRecordsResponseDto>(numRecordsResDto,HttpStatus.FOUND);
		
	}
	
	@PatchMapping("/accounts/{accountId}/block")
	public ResponseEntity<BlockedResponseDto> blockAccountByAccountId(@PathVariable Long accountId,@RequestBody BlockedRequestDto blockeddto){
		BlockedResponseDto blockresp  = accountservice.accountBlockingById(accountId,blockeddto);
		return new ResponseEntity<BlockedResponseDto>(blockresp,HttpStatus.CREATED);
		
	}


}



