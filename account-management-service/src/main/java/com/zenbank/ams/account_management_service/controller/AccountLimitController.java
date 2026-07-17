package com.zenbank.ams.account_management_service.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.AccountLimitRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountLimitResponseDto;
import com.zenbank.ams.account_management_service.dto.UpdateAccountLimitResponseDto;
import com.zenbank.ams.account_management_service.service.IAccountLimitService;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountLimitController {
	
	@Autowired
	private IAccountLimitService limitservice;
	
	@PostMapping("/{accountId}/limits")
	public ResponseEntity<Map<String,Object>> accountLimit(

	        @PathVariable Long accountId,
	        @Validated
	        @RequestBody
	        AccountLimitRequestDto requestDto){

	    AccountLimitResponseDto response =
	            limitservice.createAccountLimit(requestDto, accountId);

	    return ResponseEntity.ok(ApiResponseUtil.created(response));
	}
	
	@PutMapping("/{accountId}/limits")
	public ResponseEntity<UpdateAccountLimitResponseDto> UpdateAccountLimit(@PathVariable Long accountId,
			@Valid 
			@RequestBody 
			AccountLimitRequestDto requestDto){
		UpdateAccountLimitResponseDto updateresdto=  limitservice.updateAccountLimit(requestDto, accountId);
	
		return new ResponseEntity<UpdateAccountLimitResponseDto>(updateresdto,HttpStatus.OK);
		
	}
}
