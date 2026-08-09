package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.OperationModeRequest;
import com.zenbank.ams.account_management_service.dto.OperationModeRequest;
import com.zenbank.ams.account_management_service.entity.AccountOperation;
import com.zenbank.ams.account_management_service.exception.AccountNotFoundException;
import com.zenbank.ams.account_management_service.repository.AccountOperationModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationService {

    @Autowired
    private AccountOperationModeRepository accountOperationRepository;

    public void changeAccountOperation(Long accountId, OperationModeRequest  operationModeRequest) {

        AccountOperation account = accountOperationRepository.findById(accountId).
                orElseThrow(()-> new AccountNotFoundException("Account is not Found"+ accountId));

        if(operationModeRequest == null){
            throw  new IllegalArgumentException("Operation Mode is not Functional");
        }
        account.setOperationMode(String.valueOf(operationModeRequest));

        accountOperationRepository.save(account);
    }
}
