package com.zenbank.ams.account_management_service.service;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.zenbank.ams.account_management_service.dto.AccountChequeBookRequestDto.DeliveryAddressDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookRequestDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookResponseDto;
import com.zenbank.ams.account_management_service.dto.AccountChequeBookSearchResponseDto;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import com.zenbank.ams.account_management_service.exception.ChequeBookRequestException;
import com.zenbank.ams.account_management_service.repository.AccountChequeBookRequestRepository;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import com.zenbank.ams.account_management_service.specification.AccountChequeBookRequestSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountChequeBookRequestServiceImpl implements AccountChequeBookRequestService {

    private final AccountRepository accountRepository;
    private final AccountChequeBookRequestRepository accountChequeBookRequestRepository;

    public AccountChequeBookRequestServiceImpl(AccountRepository accountRepository,
            AccountChequeBookRequestRepository accountChequeBookRequestRepository) {
        this.accountRepository = accountRepository;
        this.accountChequeBookRequestRepository = accountChequeBookRequestRepository;
    }

    private static final List<String> ACTIVE_REQUEST_STATUSES = List.of("REQUESTED", "IN_PROGRESS", "APPROVED",
            "DISPATCHED");


    @Override
    @Transactional
    public AccountChequeBookResponseDto createAccountChequeBookRequest(AccountChequeBookRequestDto requestDto,
                                                                      Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ChequeBookRequestException("CHQ_002", "Account must exist."));

        validateAccount(account);
        validateRequest(account, requestDto, accountId);

        AccountChequeBookRequest request = new AccountChequeBookRequest();
        request.setAccountId(accountId);
        request.setCustomerId(requestDto.getCustomerId());
        request.setAccountNumber(requestDto.getAccountNumber());
        request.setChequeBookType(requestDto.getChequeBookType());
        request.setLeavesCount(requestDto.getLeavesCount());
        request.setRequestMode(requestDto.getRequestMode());
        request.setDeliveryMode(requestDto.getDeliveryMode());
        request.setDeliveryAddress(serializeAddress(requestDto.getDeliveryAddress()));
        request.setRequestStatus("REQUESTED");
        request.setCreatedBy("SYSTEM");
        request.setCreatedDate(LocalDateTime.now());
        request.setUpdatedBy("SYSTEM");
        request.setUpdatedDate(LocalDateTime.now());

        AccountChequeBookRequest savedRequest = accountChequeBookRequestRepository.save(request);

        AccountChequeBookResponseDto response = new AccountChequeBookResponseDto();
        response.setStatus("SUCCESS");
        response.setMessage("Cheque book request created successfully.");
        response.setChequeBookRequestId(formatRequestId(savedRequest.getChequeBookId()));
        response.setRequestStatus(savedRequest.getRequestStatus());
        return response;
    }

    private void validateAccount(Account account) {
        if (!"ACTIVE".equalsIgnoreCase(account.getAccountStatus())) {
            throw new ChequeBookRequestException("CHQ_002", "Account must be ACTIVE.");
        }

        if (Boolean.FALSE.equals(account.getChequeBookFacilityEnabled())) {
            throw new ChequeBookRequestException("CHQ_003", "Cheque book facility must be enabled for the account.");
        }
    }

    private void validateRequest(Account account, AccountChequeBookRequestDto requestDto, Long accountId) {
        if (!account.getAccountNumber().equals(requestDto.getAccountNumber())) {
            throw new ChequeBookRequestException("CHQ_004", "Account number does not match the selected account.");
        }

        if (!account.getCustomerId().equals(requestDto.getCustomerId())) {
            throw new ChequeBookRequestException("CHQ_005", "Customer ID does not match the selected account.");
        }

        if (!List.of(25, 50, 100).contains(requestDto.getLeavesCount())) {
            throw new ChequeBookRequestException("CHQ_006", "Leaves count must be 25, 50, or 100 only.");
        }

        if (!List.of("COURIER", "REGISTERED_POST", "BRANCH_PICKUP").contains(requestDto.getDeliveryMode())) {
            throw new ChequeBookRequestException("CHQ_007",
                    "Delivery mode must be COURIER, REGISTERED_POST, or BRANCH_PICKUP.");
        }

        boolean addressRequired = "COURIER".equalsIgnoreCase(requestDto.getDeliveryMode())
                || "REGISTERED_POST".equalsIgnoreCase(requestDto.getDeliveryMode());
        if (addressRequired && requestDto.getDeliveryAddress() == null) {
            throw new ChequeBookRequestException("CHQ_008", "Delivery address is mandatory for the selected mode.");
        }

        if (accountChequeBookRequestRepository.existsByAccountIdAndRequestStatusIn(accountId,
                ACTIVE_REQUEST_STATUSES)) {
            throw new ChequeBookRequestException("CHQ_001",
                    "An active cheque book request already exists for this account.");
        }
    }

    private String serializeAddress(DeliveryAddressDto deliveryAddressDto) {
        if (deliveryAddressDto == null) {
            return null;
        }

        return new StringBuilder(128)
                .append("{")
                .append("\"doorNumber\":\"").append(escapeJson(deliveryAddressDto.getDoorNumber())).append("\",")
                .append("\"street\":\"").append(escapeJson(deliveryAddressDto.getStreet())).append("\",")
                .append("\"area\":\"").append(escapeJson(deliveryAddressDto.getArea())).append("\",")
                .append("\"city\":\"").append(escapeJson(deliveryAddressDto.getCity())).append("\",")
                .append("\"state\":\"").append(escapeJson(deliveryAddressDto.getState())).append("\",")
                .append("\"postalCode\":\"").append(escapeJson(deliveryAddressDto.getPostalCode())).append("\",")
                .append("\"country\":\"").append(escapeJson(deliveryAddressDto.getCountry())).append("\"")
                .append("}")
                .toString();
    }

    private String formatRequestId(long requestId) {
        return "CBR" + requestId;
    }

    private String escapeJson(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    @Override
    public AccountChequeBookResponseDto getChequeBookRequest(Long accountId, Long chequeBookRequestId) {
        accountRepository.findById(accountId)
                .orElseThrow(()-> new ChequeBookRequestException("CHQ_009", "Account not found."));


        AccountChequeBookRequest chequebook = accountChequeBookRequestRepository.findByAccountIdAndChequeBookId(accountId,chequeBookRequestId)
                .orElseThrow(()-> new ChequeBookRequestException("CHQ_002", "Cheque book request ID Not found."));

        AccountChequeBookResponseDto.DataResponse dataResponse = new AccountChequeBookResponseDto.DataResponse();
        dataResponse.setChequeBookRequestId(formatRequestId(chequeBookRequestId));
        dataResponse.setAccountNumber(chequebook.getAccountNumber());
        dataResponse.setChequeBookType(chequebook.getChequeBookType());
        dataResponse.setLeavesCount(chequebook.getLeavesCount());
        dataResponse.setRequestMode(chequebook.getRequestMode());
        dataResponse.setDeliveryMode(chequebook.getDeliveryMode());
        dataResponse.setRequestStatus(chequebook.getRequestStatus());
        dataResponse.setTrackingNumber(chequebook.getTrackingNumber());
        dataResponse.setDispatchedDate(chequebook.getDispatchedDate());
        dataResponse.setDeliveredDate(chequebook.getDeliveredDate());

        AccountChequeBookResponseDto responseDto = new AccountChequeBookResponseDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setData(dataResponse);
        return responseDto;
    }


    public AccountChequeBookResponseDto updateChequeRequest(AccountChequeBookRequestDto accountChequeBookRequestDto, Long accountId, Long chequeBookRequestId) {

        accountRepository.findById(accountId)
                .orElseThrow(() -> new ChequeBookRequestException("CHQ_001", "Account not found."));

        AccountChequeBookRequest request = accountChequeBookRequestRepository.findByAccountIdAndChequeBookId(accountId, chequeBookRequestId)
                .orElseThrow(()-> new ChequeBookRequestException("CHQ_002", "Cheque book request ID Not found."));

        if ("DISPATCHED".equalsIgnoreCase(request.getRequestStatus())) {
            throw new ChequeBookRequestException("CHQ_003", "Cheque book request cannot be updated after dispatch.");

        }

        request.setDeliveryMode(accountChequeBookRequestDto.getDeliveryMode());
        request.setDeliveryAddress(serializeAddress(accountChequeBookRequestDto.getDeliveryAddress()));

        accountChequeBookRequestRepository.save(request);

        AccountChequeBookResponseDto responseDto = new AccountChequeBookResponseDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("Cheque book request updated successfully.");

        return responseDto;
    }

    @Override
    public AccountChequeBookSearchResponseDto searchChequeBookRequests(String accountNumber, String customerId, String requestStatus, String chequeBookType, String requestMode, LocalDate fromDate, LocalDate toDate, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<AccountChequeBookRequest> result = accountChequeBookRequestRepository.searchChequeBookRequests(
                accountNumber,customerId,requestStatus,chequeBookType,requestMode,
                fromDate == null ? null : fromDate.atStartOfDay(),
                toDate ==  null ? null : toDate.atTime(23,59,59),pageable);
        if (result.isEmpty()) {
            throw new ChequeBookRequestException(
                    "CHQ_001",
                    "No cheque book requests found.");
        }
        List<AccountChequeBookSearchResponseDto.SearchData> data =
                result.getContent()
                        .stream()
                        .map(request ->{
                            AccountChequeBookSearchResponseDto.SearchData responseDto =
                                    new AccountChequeBookSearchResponseDto.SearchData();

                            responseDto.setChequeBookRequestId(formatRequestId(request.getChequeBookId()));
                            responseDto.setAccountNumber(request.getAccountNumber());
                            responseDto.setChequeBookType(request.getChequeBookType());
                            responseDto.setLeavesCount(request.getLeavesCount());
                            responseDto.setRequestStatus(request.getRequestStatus());
                            responseDto.setRequestMode(request.getRequestMode());

                            return responseDto;

                        }).toList();

        AccountChequeBookSearchResponseDto response = new  AccountChequeBookSearchResponseDto();
        response.setStatus("SUCCESS");
        response.setPage(result.getNumber());
        response.setSize(result.getSize());
        response.setTotalRecords(result.getTotalElements());
        response.setData(data);


        return response;
    }


}
