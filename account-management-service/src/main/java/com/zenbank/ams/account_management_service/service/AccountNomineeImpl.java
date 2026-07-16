package com.zenbank.ams.account_management_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountNomineeRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountNomineeResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountNominee;
import com.zenbank.ams.account_management_service.exception.AccountNotFoundException;
import com.zenbank.ams.account_management_service.exception.InvalidNomineeShareException;
import com.zenbank.ams.account_management_service.repository.AccountNomineeRepo;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
@Service
public class AccountNomineeImpl implements AccountNomineeService{

	@Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountNomineeRepo accountNomineeRepository;

    @Override
    public AccountNomineeResponseDto addNominee(Long accountId,
            AccountNomineeRequestDto requestDto) {

    
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

 
        List<AccountNominee> nominees =
                accountNomineeRepository.findByAccountIdAccountId(accountId);

        BigDecimal totalShare = BigDecimal.ZERO;

        for (AccountNominee nominee : nominees) {
            totalShare = totalShare.add(nominee.getSharePercentage());
        }

        
        BigDecimal newTotal =
                totalShare.add(requestDto.getSharePercentage());

        if (newTotal.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidNomineeShareException(
                    "Total nominee share percentage cannot exceed 100%");
        }

        
        AccountNominee accountNominee = new AccountNominee();

        accountNominee.setAccountId(account);
        accountNominee.setNomineeName(requestDto.getNomineeName());
        accountNominee.setRelationship(requestDto.getRelationship());
        accountNominee.setMobileNumber(requestDto.getMobileNumber());
        accountNominee.setDob(requestDto.getDob());
        accountNominee.setSharePercentage(requestDto.getSharePercentage());

        accountNominee.setVerificationStatus("PENDING");

        accountNominee.setCreatedDate(LocalDateTime.now());
        accountNominee.setUpdatedDate(LocalDateTime.now());

     
        accountNomineeRepository.save(accountNominee);

    
        AccountNomineeResponseDto response =
                new AccountNomineeResponseDto();

        response.setStatus("SUCCESS");
        response.setMessage("Account nominee added successfully.");
        response.setNomineeId("AN" + accountNominee.getNomineeId());

        return response;

}
}
