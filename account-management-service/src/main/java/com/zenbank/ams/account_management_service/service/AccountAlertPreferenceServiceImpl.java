package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountAlertPreferenceResponse;
import com.zenbank.ams.account_management_service.dto.CreateAccountAlertPreferenceRequest;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountAlertPreference;
import com.zenbank.ams.account_management_service.exception.BusinessException;
import com.zenbank.ams.account_management_service.exception.ResourceNotFoundException;
import com.zenbank.ams.account_management_service.repository.AccountAlertPreferenceRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
@Service
public class AccountAlertPreferenceServiceImpl  implements AccountAlertPreferenceService{

	private AccountRepository accountRepository;
	
	private AccountAlertPreferenceRepository repository;
	
	
	
	
	public AccountAlertPreferenceServiceImpl(AccountRepository accountRepository,
			AccountAlertPreferenceRepository repository) {
		super();
		this.accountRepository = accountRepository;
		this.repository = repository;
	}




	@Override
	public AccountAlertPreferenceResponse createPreferance(Long accountId,
			CreateAccountAlertPreferenceRequest request) {
		
		Account account=accountRepository.findById(accountId)
				.orElseThrow(
						()-> new ResourceNotFoundException("Account not found")
						);
		
		if(!"ACTIVE".equalsIgnoreCase(account.getAccountStatus()))
		{
			throw new BusinessException("Alert preference already exists for this account");
		}
		
		 if ("Y".equalsIgnoreCase(request.getLargeTransactionAlert())) {

	            if (request.getLargeTransactionAmount() == null
	                    || request.getLargeTransactionAmount().doubleValue() <= 0) {

	                throw new BusinessException(
	                        "Large transaction amount must be greater than zero.");
	            }
	        }

	        if ("Y".equalsIgnoreCase(request.getLowBalanceAlert())) {

	            if (request.getMinimumBalance() == null
	                    || request.getMinimumBalance().doubleValue() <= 0) {

	                throw new BusinessException(
	                        "Minimum balance should be greater than zero.");
	            }
	        }

	        if (!(request.getNotificationMode().equalsIgnoreCase("SMS")
	                || request.getNotificationMode().equalsIgnoreCase("EMAIL")
	                || request.getNotificationMode().equalsIgnoreCase("BOTH"))) {

	            throw new BusinessException("Invalid notification mode.");
	        }

	        AccountAlertPreference preference = new AccountAlertPreference();

	        preference.setAccount(account);
	        preference.setDebitAlert(request.getDebitAlert());
	        preference.setCreditAlert(request.getCreditAlert());
	        preference.setLowBalanceAlert(request.getLowBalanceAlert());
	        preference.setMinimumBalance(request.getMinimumBalance());
	        preference.setChequeBounceAlert(request.getChequeBounceAlert());
	        preference.setEmiDueAlert(request.getEmiDueAlert());
	        preference.setInterestCreditAlert(request.getInterestCreditAlert());
	        preference.setLoginAlert(request.getLoginAlert());
	        preference.setLargeTransactionAlert(request.getLargeTransactionAlert());
	        preference.setLargeTransactionAmount(request.getLargeTransactionAmount());
	        preference.setNotificationMode(request.getNotificationMode());
	        preference.setMobileNumber(request.getMobileNumber());
	        preference.setEmail(request.getEmail());

	        preference.setStatus("ACTIVE");
	        preference.setCreatedBy("SYSTEM");
	        preference.setCreatedDate(LocalDateTime.now());

	        AccountAlertPreference saved = repository.save(preference);

	        //  Save Audit Record

	        AccountAlertPreferenceResponse response =
	                new AccountAlertPreferenceResponse();

	        response.setStatus("SUCCESS");
	        response.setMessage("Account alert preference created successfully.");
	        response.setPreferenceId("ALP" + (100000 + saved.getPreferenceId()));

	        return response;
	}

}
