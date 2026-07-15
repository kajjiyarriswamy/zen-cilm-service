package com.zenbank.ams.account_management_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.AccountRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountResponseDto;
import com.zenbank.ams.account_management_service.service.AccountServiceI;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtility;


@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountServiceI accountservice;
	
	
	@PostMapping("/v1/accounts")
	public ResponseEntity<Map<String, Object>> createAccount(@RequestBody AccountRequestDto requestDto ){
		 AccountResponseDto responsedto = accountservice.accountCreate(requestDto);
	     return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtility.accountCreated(responsedto));
		 
	}

}
