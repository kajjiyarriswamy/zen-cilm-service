package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.AccountStatusChangeRequest;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountStatus;
import com.zenbank.ams.account_management_service.entity.AccountStatusHistory;
import com.zenbank.ams.account_management_service.exception.CustomerNotFound;
import com.zenbank.ams.account_management_service.repository.AccountStatusHistoryRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AccountStatusService {

    private final AccountRepository accountRepository;
    private final AccountStatusHistoryRepository statusHistoryRepository;

    public AccountStatusService(AccountRepository accountRepository, AccountStatusHistoryRepository statusHistoryRepository) {
        this.accountRepository = accountRepository;
        this.statusHistoryRepository = statusHistoryRepository;
    }


    @Transactional
    public void blockAccount(long accountId, AccountStatusChangeRequest request) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new CustomerNotFound("Customer is Not Found!!!"));


        validBlock(account);
        if("BLOCKED".equalsIgnoreCase(account.getAccountStatus())){

            throw  new RuntimeException("Account is already blocked"); }

        account.setAccountStatus("BLOCKED");
        account.setUpdatedDate(LocalDate.now());
        accountRepository.save(account) ;

        AccountStatusHistory history = new AccountStatusHistory();

        history.setAccount(account);

        history.setAction("BLOCKED");
        history.setReason(request.getReason());
        history.setPerformedBy(history.getPerformedBy());
        history.setPerformedAt(LocalDateTime.now());
        statusHistoryRepository.save(history);
    }

    private void validBlock(Account account) {

    }

    @Transactional
    public void changeStatus(Long accountId, String dormant, AccountStatusChangeRequest request){

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new CustomerNotFound("Customer is Not Found!!!"));

        account.setAccountStatus(AccountStatus.DORMANT);

        account.setUpdatedDate(LocalDate.now());
        accountRepository.save(account);

        AccountStatusHistory history = new AccountStatusHistory();
        history.setAccount(account);
        history.setAction("DORMANT");
        history.setReason(request.getReason());
        history.setPerformedBy("ADMIN");
        history.setPerformedAt(LocalDateTime.now());
        statusHistoryRepository.save(history);
    }
}
