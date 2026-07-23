package com.zenbank.ams.account_management_service.controller;

import com.zenbank.ams.account_management_service.dto.AccountStatusChangeRequest;
import com.zenbank.ams.account_management_service.entity.AccountStatus;
import com.zenbank.ams.account_management_service.service.AccountStatusService;
import com.zenbank.ams.account_management_service.utility.ApiResponseUtility;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class BlockAccountController {

    private final AccountStatusService accountStatusServiceService;

    public BlockAccountController(AccountStatusService blockService, AccountStatusService accountStatusServiceService) {
        this.accountStatusServiceService = accountStatusServiceService;
    }

    @PutMapping("/{accountId}/block")
    public ResponseEntity<Map<String, Object>> blockAccount(
            @PathVariable Long accountId,
            @RequestBody AccountStatusChangeRequest request) {

        accountStatusServiceService.blockAccount(accountId, request);

        return ResponseEntity.ok(
                ApiResponseUtility.success("Account blocked successfully.")
        );
    }

    @Transactional
    @PutMapping("/{accountId}/dormant")
    public ResponseEntity<Map<String, Object>> dormantAccount(
            @PathVariable Long accountId,
            @RequestBody AccountStatusChangeRequest request){

        accountStatusServiceService.changeStatus(accountId,
                AccountStatus.DORMANT,
                request);

            return ResponseEntity.ok(
                    ApiResponseUtility.success("Account Marked as dormant")
            );
    }
}