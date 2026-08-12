package com.zenbank.deposit_service.service;

import com.zenbank.deposit_service.dto.AccountDetailsResponseDto;
import com.zenbank.deposit_service.dto.BalanceUpdateRequestDto;
import com.zenbank.deposit_service.dto.CreateDepositRequest;
import com.zenbank.deposit_service.dto.DepositResponse;
import com.zenbank.deposit_service.dto.CustomerDetailsResponseDto;
import com.zenbank.deposit_service.dto.CilmResponseWrapper;
import com.zenbank.deposit_service.entity.DepositChannel;
import com.zenbank.deposit_service.entity.DepositReceipt;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.entity.DepositType;
import com.zenbank.deposit_service.enums.DepositStatus;
import com.zenbank.deposit_service.enums.DepositTypeCode;

import com.zenbank.deposit_service.exception.DepositException;
import com.zenbank.deposit_service.repository.DepositAuditRepository;
import com.zenbank.deposit_service.repository.DepositChannelRepository;
import com.zenbank.deposit_service.repository.DepositReceiptRepository;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;
import com.zenbank.deposit_service.repository.DepositTypeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DepositService {

    private final RestTemplate restTemplate;
    private final DepositTransactionRepository depositTransactionRepository;
    private final DepositReceiptRepository depositReceiptRepository;
    private final DepositTypeRepository depositTypeRepository;
    private final DepositChannelRepository depositChannelRepository;

    @Value("${cilm-service.url}")
    private String cilmServiceUrl;

    @Value("${account-management-service.url}")
    private String amsServiceUrl;

    public DepositService(
            RestTemplate restTemplate,
            DepositTransactionRepository depositTransactionRepository,
            DepositReceiptRepository depositReceiptRepository,
            DepositAuditRepository depositAuditRepository,
            DepositTypeRepository depositTypeRepository,
            DepositChannelRepository depositChannelRepository,
            ApplicationEventPublisher eventPublisher) {
        this.restTemplate = restTemplate;
        this.depositTransactionRepository = depositTransactionRepository;
        this.depositReceiptRepository = depositReceiptRepository;
        this.depositTypeRepository = depositTypeRepository;
        this.depositChannelRepository = depositChannelRepository;
    }

    @Transactional
    public DepositResponse executeDeposit(CreateDepositRequest request) {
        // 1. Validate Deposit Amount
        if (request.getAmount() == null || request.getAmount() <= 0) {
            throw new DepositException("DEP_003", "Deposit amount should be greater than zero.");
        }

        // 2. Validate Customer Status via RestTemplate
        CilmResponseWrapper customerResponse;
        try {
            String customerIdStr = "CUS" + request.getCustomerId();
            String url = cilmServiceUrl + "/api/v1/customers/" + customerIdStr;
            customerResponse = restTemplate.getForObject(url, CilmResponseWrapper.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new DepositException("DEP_004", "Customer not found.");
        } catch (Exception ex) {
            throw new DepositException("DEP_004", "Customer not found.");
        }

        if (customerResponse == null || !"SUCCESS".equalsIgnoreCase(customerResponse.getSuccess())) {
            throw new DepositException("DEP_004", "Customer not found.");
        }

        CustomerDetailsResponseDto customerData = customerResponse.getData();
        if (customerData == null || !"ACTIVE".equalsIgnoreCase(customerData.getStatus())) {
            throw new DepositException("DEP_004", "Customer not found.");
        }

        // 3. Validate Account via RestTemplate
        AccountDetailsResponseDto accountDetails;
        try {
            String url = amsServiceUrl + "/api/v1/accounts/" + request.getAccountId();
            accountDetails = restTemplate.getForObject(url, AccountDetailsResponseDto.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new DepositException("DEP_001", "Account not found.");
        } catch (Exception ex) {
            throw new DepositException("DEP_001", "Account not found.");
        }

        if (accountDetails == null) {
            throw new DepositException("DEP_001", "Account not found.");
        }

        if (!"ACTIVE".equalsIgnoreCase(accountDetails.getAccountStatus())) {
            throw new DepositException("DEP_002", "Account is inactive.");
        }

        // Verify Currency matches
        if (request.getCurrency() != null && !request.getCurrency().equalsIgnoreCase(accountDetails.getCurrency())) {
            throw new DepositException("DEP_003", "Unsupported currency. Account currency is " + accountDetails.getCurrency());
        }

        // 4. Verify Deposit Type
        DepositTypeCode typeCode;
        try {
            typeCode = DepositTypeCode.valueOf(request.getDepositTypeCode().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DepositException("DEP_003", "Invalid deposit type.");
        }

        DepositType depositType = depositTypeRepository.findByTypeCode(typeCode)
                .orElseThrow(() -> new DepositException("DEP_003", "Invalid deposit type."));

        // 5. Verify Deposit Channel
        DepositChannel depositChannel = depositChannelRepository.findByChannelCode(request.getDepositChannelCode().toUpperCase())
                .orElseThrow(() -> new DepositException("DEP_003", "Invalid deposit channel."));

        // 6. Update Account Balance via RestTemplate
        AccountDetailsResponseDto updatedAccount = updateAccountBalance(request.getAccountId(), request.getAmount());
        if (updatedAccount == null) {
            throw new DepositException("DEP_003", "Failed to update account balance.");
        }

        // 7. Save Deposit Transaction Record
        String txRef = "DEP" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        DepositTransaction transaction = new DepositTransaction();
        transaction.setTransactionReference(txRef);
        transaction.setAccountId(request.getAccountId());
        transaction.setCustomerId(request.getCustomerId());
        transaction.setDepositType(depositType);
        transaction.setDepositChannel(depositChannel);
        transaction.setDepositChannelName(depositChannel.getChannelCode());
        transaction.setDepositTypeName(depositType.getTypeName());
        transaction.setStatus("SUCCESS");
        transaction.setAmount(BigDecimal.valueOf(request.getAmount()));
        transaction.setCurrency(request.getCurrency());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setValueDate(LocalDate.now());
        transaction.setTransactionStatus("SUCCESS");
        transaction.setRemarks(request.getRemarks());
        transaction.setBranchCode(request.getBranchCode());
        transaction.setBranchName(request.getBranchName());
        transaction.setInitiatedBy("TELLER");
        transaction.setApprovedBy("SYSTEM");
        transaction.setApprovalStatus("APPROVED");
        transaction.setCreatedBy("TELLER");
        transaction.setCreatedDate(LocalDate.now());
        transaction.setUpdatedBy("TELLER");
        transaction.setUpdatedDate(LocalDateTime.now());

        DepositTransaction savedTransaction = depositTransactionRepository.save(transaction);

        //  Generate Receipt Record
        DepositReceipt receipt = new DepositReceipt();
        receipt.setDepositTransaction(savedTransaction);
        receipt.setReceiptNumber("REC" + savedTransaction.getDepositId() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("SSS")));
        receipt.setReceiptDate(LocalDateTime.now());
        receipt.setContent("Deposit receipt for Transaction: " + txRef + ". Amount: " + request.getAmount() + " " + request.getCurrency());
        receipt.setGeneratedDate(LocalDateTime.now());
        receipt.setReceiptType("DEPOSIT");
        receipt.setGeneratedBy("SYSTEM");
        receipt.setReceiptStatus("GENERATED");
        receipt.setCreatedBy("TELLER");
        receipt.setCreatedDate(LocalDateTime.now());
        receipt.setUpdatedBy("TELLER");
        receipt.setUpdatedDate(LocalDateTime.now());
        
        DepositReceipt savedReceipt = depositReceiptRepository.save(receipt);
        savedTransaction.setDepositReceipt(savedReceipt);
        depositTransactionRepository.save(savedTransaction);
//
//        // Create Audit Record
//        DepositAudit audit = new DepositAudit();
//        audit.setDepositTransaction(savedTransaction);
//        audit.setAccountId(request.getAccountId());
//        audit.setCustomerId("CUS" + request.getCustomerId());
//        audit.setAmount(request.getAmount());
//        audit.setStatus("SUCCESS");
//        audit.setAction("CREATE_DEPOSIT");
//        audit.setPerformedBy("TELLER");
//        audit.setOldValue("AVAILABLE_BALANCE: " + accountDetails.getAvailableBalance());
//        audit.setNewValue("AVAILABLE_BALANCE: " + updatedAccount.getAvailableBalance());
//        audit.setIpAddress("127.0.0.1");
//        audit.setDeviceInfo("Web-Client");
//        audit.setAuditStatus("SUCCESS");
//        audit.setCreatedDate(LocalDate.now());
//
//        depositAuditRepository.save(audit);

        //  Prepare and return success response DTO
        DepositResponse.DepositResponseData data = new DepositResponse.DepositResponseData(
                savedTransaction.getDepositId(),
                savedTransaction.getTransactionReference(),
                savedTransaction.getCustomerId(),
                savedTransaction.getAccountId(),
                savedTransaction.getDepositType().getTypeName(),
                savedTransaction.getDepositChannel().getChannelCode(),
                savedTransaction.getAmount(),
                savedTransaction.getCurrency(),
                savedTransaction.getTransactionStatus(),
                savedTransaction.getTransactionDate(),
                updatedAccount.getAvailableBalance(),
                savedReceipt.getReceiptNumber()
        );

        return new DepositResponse("SUCCESS", "Deposit transaction created successfully.", data);
    }

    private AccountDetailsResponseDto updateAccountBalance(Long accountId, Double amount) {
        String url = amsServiceUrl + "/api/v1/accounts/" + accountId + "/balance";
        BalanceUpdateRequestDto updateRequestDto = new BalanceUpdateRequestDto(amount);
        try {
            return restTemplate.postForObject(url, updateRequestDto, AccountDetailsResponseDto.class);
        } catch (Exception ex) {
            // Spring REST fallback
            try {
                restTemplate.put(url, updateRequestDto);
                // Refetch balance
                String getUrl = amsServiceUrl + "/api/v1/accounts/" + accountId;
                return restTemplate.getForObject(getUrl, AccountDetailsResponseDto.class);
            } catch (Exception e) {
                throw new DepositException("DEP_003", "Failed to update account balance in Account Management Service.");
            }
        }
    }
}
