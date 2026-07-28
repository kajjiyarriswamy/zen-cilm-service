package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;

import com.zenbank.ams.account_management_service.dto.CreatePassbookRequest;
import com.zenbank.ams.account_management_service.dto.PassbookRequestDetailsResponse;
import com.zenbank.ams.account_management_service.dto.PassbookRequestResponse;
import com.zenbank.ams.account_management_service.dto.SearchPassbookRequestResponse;
import com.zenbank.ams.account_management_service.dto.UpdateNicknameRequest;

public interface AccountPassbookRequestService {

	PassbookRequestResponse createRequest(Long accountId, CreatePassbookRequest request);

	PassbookRequestDetailsResponse getPassbookRequest(Long accountId, Long passbookRequestId);

	PassbookRequestResponse updatePassbookRequest(Long accountId, Long passbookRequestId,
			CreatePassbookRequest request);

	SearchPassbookRequestResponse searchPassbookRequest(String accountNumber, String customerId, String requestType,
			String requestStatus, String requestMode, String deliveryMode, String branchCode, LocalDate fromDate,
			LocalDate toDate, int page, int size);
	
	PassbookRequestResponse updateNickname(Long accountId, UpdateNicknameRequest request);

}
