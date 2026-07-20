package com.zenbank.ams.account_management_service.service;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;
import com.zenbank.ams.account_management_service.dto.DispatchAddress;
import com.zenbank.ams.account_management_service.entity.Account;
import com.zenbank.ams.account_management_service.entity.AccountDebitCard;
import com.zenbank.ams.account_management_service.exception.DebitCardException;
import com.zenbank.ams.account_management_service.repository.AccountRepository;
import com.zenbank.ams.account_management_service.repository.DebitCardRepository;


@Service
@Transactional
public class DebitCardServiceImpl implements DebitCardService {

    private static final List<String> ACTIVE_REQUEST_STATUS =
            List.of("REQUESTED", "APPROVED", "PRINTED", "DISPATCHED", "ACTIVE");

    private final AccountRepository accountRepository;
    private final DebitCardRepository debitCardRepository;

    public DebitCardServiceImpl(AccountRepository accountRepository,
                                DebitCardRepository debitCardRepository) {
        this.accountRepository = accountRepository;
        this.debitCardRepository = debitCardRepository;
    }

    @Override
    public DebitCardResponse createDebitCardRequest(DebitCardRequest requestDto, Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new DebitCardException("CARD_002", "Account not found."));

        validateAccount(account);

        validateRequest(account, requestDto, accountId);

        AccountDebitCard debitCard = new AccountDebitCard();

        debitCard.setAccount(account);
        debitCard.setCustomerId(account.getCustomerId());
        debitCard.setAccountNumber(account.getAccountNumber());
        debitCard.setCardType(requestDto.getCardType());
        debitCard.setCardVariant(requestDto.getCardVariant());
        debitCard.setCardHolderName(requestDto.getCardHolderName());
        debitCard.setIssueType(requestDto.getIssueType());
        debitCard.setRequestMode(requestDto.getRequestMode());
        debitCard.setDeliveryMode(requestDto.getDeliveryMode());
        debitCard.setDispatchAddress(serializeAddress(requestDto.getDispatchAddress()));

        debitCard.setCardStatus("REQUESTED");
        debitCard.setCreatedBy("SYSTEM");
        debitCard.setCreatedDate(LocalDateTime.now());
        debitCard.setUpdatedBy("SYSTEM");
        debitCard.setUpdatedDate(LocalDateTime.now());

        AccountDebitCard savedCard = debitCardRepository.save(debitCard);

        DebitCardResponse response = new DebitCardResponse();
        response.setStatus("SUCCESS");
        response.setMessage("Debit Card Request Created Successfully.");
        response.setDebitCardRequestId("DCR" + savedCard.getDebitCardId());
        response.setCardStatus(savedCard.getCardStatus());

        return response;
    }

    private void validateAccount(Account account) {

        if (!"ACTIVE".equalsIgnoreCase(account.getAccountStatus())) {
            throw new DebitCardException(
                    "CARD_003",
                    "Account must be ACTIVE.");
        }
    }

    private void validateRequest(Account account,
                                 DebitCardRequest requestDto,
                                 Long accountId) {

        if (!account.getAccountNumber().equals(requestDto.getAccountNumber())) {
            throw new DebitCardException(
                    "CARD_004",
                    "Account number does not match.");
        }

        if (!account.getCustomerId().equals(requestDto.getCustomerId())) {
            throw new DebitCardException(
                    "CARD_005",
                    "Customer ID does not match.");
        }

        if (debitCardRepository.existsByAccount_AccountIdAndCardStatusIn(
                accountId,
                ACTIVE_REQUEST_STATUS)) {

            throw new DebitCardException(
                    "CARD_001",
                    "An active debit card request already exists.");
        }

        boolean addressRequired =
                "COURIER".equalsIgnoreCase(requestDto.getDeliveryMode())
                || "REGISTERED_POST".equalsIgnoreCase(requestDto.getDeliveryMode());

        if (addressRequired && requestDto.getDispatchAddress() == null) {
            throw new DebitCardException(
                    "CARD_006",
                    "Dispatch address is mandatory.");
        }
    }

    private String serializeAddress(DispatchAddress address) {

        if (address == null) {
            return null;
        }

        return new StringBuilder()
                .append("{")
                .append("\"doorNumber\":\"").append(address.getDoorNumber()).append("\",")
                .append("\"street\":\"").append(address.getStreet()).append("\",")
                .append("\"area\":\"").append(address.getArea()).append("\",")
                .append("\"city\":\"").append(address.getCity()).append("\",")
                .append("\"state\":\"").append(address.getState()).append("\",")
                .append("\"postalCode\":\"").append(address.getPostalCode()).append("\",")
                .append("\"country\":\"").append(address.getCountry()).append("\"")
                .append("}")
                .toString();
    }
}