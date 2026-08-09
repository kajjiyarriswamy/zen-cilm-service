package com.zenbank.ams.account_management_service.controller;

import com.zenbank.ams.account_management_service.dto.OperationModeRequest;
import com.zenbank.ams.account_management_service.service.AccountOperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountOperationController {

    private final AccountOperationService accountOperationService;

    public AccountOperationController(AccountOperationService accountOperationService) {
        this.accountOperationService = accountOperationService;
    }

    @PutMapping("/{accountId}/operation-mode")
    public ResponseEntity<String> changeAccountOperation(
            @PathVariable Long accountId,
            @RequestBody OperationModeRequest operationModeRequest){
        accountOperationService.changeAccountOperation(accountId, operationModeRequest);

        return ResponseEntity.ok("Account Operation Updated Successfully");
    }

}
