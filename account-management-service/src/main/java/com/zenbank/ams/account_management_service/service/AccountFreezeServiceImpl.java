package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountFreezeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountFreezeResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountFreeze;
import com.zenbank.ams.account_management_service.exception.AccountNotFoundException;
import com.zenbank.ams.account_management_service.repository.AccountFreezeRepo;
import com.zenbank.ams.account_management_service.repository.AccountRepository;

@Service
public class AccountFreezeServiceImpl implements AccountFreezeService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountFreezeRepo accountFreezeRepo;

    @Override
    public AccountFreezeResponseDto freezeDebit(Long accountId, AccountFreezeRequestDto request) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        AccountFreeze freeze = new AccountFreeze();

        freeze.setAccountId(account.getAccountId());
        freeze.setFreezeType("DEBIT");
        freeze.setReason(request.getReason());
        freeze.setStatus("ACTIVE");
        freeze.setCreatedDate(LocalDateTime.now());

        accountFreezeRepo.save(freeze);

        AccountFreezeResponseDto response = new AccountFreezeResponseDto();
        response.setStatus("SUCCESS");
        response.setMessage("Debit transactions frozen successfully.");

        return response;

}
    @Override
    public AccountFreezeResponseDto freezeCredit(Long accountId, AccountFreezeRequestDto request) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        AccountFreeze freeze = new AccountFreeze();

        freeze.setAccountId(account.getAccountId());
        freeze.setFreezeType("CREDIT");
        freeze.setReason(request.getReason());
        freeze.setStatus("ACTIVE");
        freeze.setCreatedDate(LocalDateTime.now());

        accountFreezeRepo.save(freeze);

        AccountFreezeResponseDto response = new AccountFreezeResponseDto();
        response.setStatus("SUCCESS");
        response.setMessage("Credit transactions frozen successfully.");

        return response;
    }
    @Override
    public AccountFreezeResponseDto unfreezeAccount(
            Long accountId,
            AccountFreezeRequestDto request) {

        accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        List<AccountFreeze> freezes =
                accountFreezeRepo.findByAccountIdAndStatus(accountId, "ACTIVE");

        if (freezes.isEmpty()) {
            throw new RuntimeException("Account is not frozen");
        }

        for (AccountFreeze freeze : freezes) {
            freeze.setStatus("INACTIVE");
            freeze.setReason(request.getReason());
        }

        accountFreezeRepo.saveAll(freezes);

        return new AccountFreezeResponseDto(
                "SUCCESS",
                "Account unfrozen successfully.");
    }
}
