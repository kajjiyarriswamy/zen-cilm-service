package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.dto.AccountNomineeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountNomineeResponseDto;
import com.zenbank.ams.account_management_service.service.AccountNomineeService;



@RestController
@RequestMapping("/api/v1/accounts")
public class AccountNomineeController {

    @Autowired
    private AccountNomineeService accountNomineeService;

    @PostMapping("/{accountId}/nominees")
    public ResponseEntity<AccountNomineeResponseDto> addNominee(
            @PathVariable Long accountId,
            @RequestBody  AccountNomineeRequestDto requestDto) {

        AccountNomineeResponseDto response =
                accountNomineeService.addNominee(accountId, requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
