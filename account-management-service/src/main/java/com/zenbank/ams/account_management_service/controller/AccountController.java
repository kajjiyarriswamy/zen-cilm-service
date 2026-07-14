package com.zenbank.ams.account_management_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.service.AccountServiceI;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountServiceI accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        Account savedAccount = accountService.createAccount(account);

        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }
}