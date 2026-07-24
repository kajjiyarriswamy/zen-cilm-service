package com.zenbank.ams.account_management_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.zenbank.ams.account_management_service.dto.AccountAlertPreferenceResponse;
import com.zenbank.ams.account_management_service.dto.AlertPreferenceData;
import com.zenbank.ams.account_management_service.dto.CreateAccountAlertPreferenceRequest;
import com.zenbank.ams.account_management_service.dto.GetAlertPreference;
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
	
	
	@Override
	public GetAlertPreference getAlertPreference(Long accountId) {

	    AccountAlertPreference preference = repository
	            .findByAccount_AccountId(accountId)
	            .orElseThrow(() -> new ResourceNotFoundException("Alert preference not found."));

	    AlertPreferenceData data = new AlertPreferenceData();

	    data.setPreferenceId("ALP" + (100000 + preference.getPreferenceId()));
	    data.setDebitAlert(preference.getDebitAlert());
	    data.setCreditAlert(preference.getCreditAlert());
	    data.setLowBalanceAlert(preference.getLowBalanceAlert());
	    data.setMinimumBalance(preference.getMinimumBalance());
	    data.setChequeBounceAlert(preference.getChequeBounceAlert());
	    data.setEmiDueAlert(preference.getEmiDueAlert());
	    data.setInterestCreditAlert(preference.getInterestCreditAlert());
	    data.setLoginAlert(preference.getLoginAlert());
	    data.setLargeTransactionAlert(preference.getLargeTransactionAlert());
	    data.setLargeTransactionAmount(preference.getLargeTransactionAmount());
	    data.setNotificationMode(preference.getNotificationMode());
	    data.setMobileNumber(preference.getMobileNumber());
	    data.setEmail(preference.getEmail());
	    data.setStatus(preference.getStatus());

	    GetAlertPreference response = new GetAlertPreference();
	    response.setStatus("SUCCESS");
	    response.setData(data);

	    return response;
	}

	@Override
	public AccountAlertPreferenceResponse updateAlertPreference(
	        Long accountId,
	        CreateAccountAlertPreferenceRequest request) {

	    // Validate Account
	    Account account = accountRepository.findById(accountId)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Account not found."));

	    if (!"ACTIVE".equalsIgnoreCase(account.getAccountStatus())) {
	        throw new BusinessException("Account is not active.");
	    }

	    // Find Existing Preference
	    AccountAlertPreference preference = repository
	            .findByAccount_AccountId(accountId)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Alert preference not found."));

	    // Validation
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
	                    "Minimum balance must be greater than zero.");
	        }
	    }

	    if (!(request.getNotificationMode().equalsIgnoreCase("SMS")
	            || request.getNotificationMode().equalsIgnoreCase("EMAIL")
	            || request.getNotificationMode().equalsIgnoreCase("BOTH"))) {

	        throw new BusinessException("Invalid notification mode.");
	    }

	    // Update Fields
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
	    preference.setStatus(request.getStatus());

	    preference.setUpdatedBy("SYSTEM");
	    preference.setUpdatedDate(LocalDateTime.now());

	    repository.save(preference);

	    //  Save Audit Record

	    AccountAlertPreferenceResponse response =
	            new AccountAlertPreferenceResponse();

	    response.setStatus("SUCCESS");
	    response.setMessage("Account alert preference updated successfully.");

	    return response;
	}
	
}
