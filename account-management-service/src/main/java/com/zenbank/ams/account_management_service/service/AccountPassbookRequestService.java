package com.zenbank.ams.account_management_service.service;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;

public interface AccountPassbookRequestService {

	PassbookRequestResponse createRequest(Long accountId, CreatePassbookRequest request);

}
