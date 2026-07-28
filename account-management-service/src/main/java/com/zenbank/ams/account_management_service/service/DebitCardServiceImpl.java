package com.zenbank.ams.account_management_service.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenbank.ams.account_management_service.dto.DebitCardRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardResponse;
import com.zenbank.ams.account_management_service.dto.DebitCardResponseDto;
import com.zenbank.ams.account_management_service.dto.DebitCardUpdateRequest;
import com.zenbank.ams.account_management_service.dto.DebitCardUpdateResponse;
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
        debitCard.setCardNumber(requestDto.getCardNumber());
        debitCard.setCardType(requestDto.getCardType());
        debitCard.setCardVariant(requestDto.getCardVariant());
        debitCard.setCardHolderName(requestDto.getCardHolderName());
        debitCard.setIssueType(requestDto.getIssueType());
        debitCard.setRequestMode(requestDto.getRequestMode());
        debitCard.setDeliveryMode(requestDto.getDeliveryMode());
        debitCard.setDispatchAddress(serializeAddress(requestDto.getDispatchAddress()));

        debitCard.setCardStatus(requestDto.getCardStatus());
        debitCard.setExpiryMonth(requestDto.getExpiryMonth());
        debitCard.setExpiryYear(requestDto.getExpiryYear());

        debitCard.setTrackingNumber(requestDto.getTrackingNumber());

        debitCard.setDispatchedDate(LocalDate.now());
        debitCard.setActivatedDate(LocalDate.now().plusDays(2));

        debitCard.setRemarks(requestDto.getRemarks());

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
        
        
        DispatchAddress address = requestDto.getDispatchAddress();

        System.out.println("Dispatch Address Object : " + address);

        String addressJson = serializeAddress(address);

        System.out.println("Serialized Address : " + addressJson);

        debitCard.setDispatchAddress(addressJson);

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
    
    
    @Override
    public DebitCardResponseDto getDebitCardByAccountIdAndDebitCardId(Long accountId, Long debitCardId) {

        AccountDebitCard debitCard = debitCardRepository
                .findByAccountAccountIdAndDebitCardId(accountId, debitCardId)
                .orElseThrow(() -> new DebitCardException(
                        "CARD_404",
                        "Debit Card not found"));

        DebitCardResponseDto response = new DebitCardResponseDto();

        response.setDebitCardId(debitCard.getDebitCardId());
        response.setAccountNumber(debitCard.getAccountNumber());

        String cardNumber = debitCard.getCardNumber();
        if (cardNumber != null && cardNumber.length() >= 4) {
            response.setCardNumber("XXXX XXXX XXXX " + cardNumber.substring(cardNumber.length() - 4));
        } else {
            response.setCardNumber(cardNumber);
        }

        response.setCardType(debitCard.getCardType());
        response.setCardVariant(debitCard.getCardVariant());
        response.setCardHolderName(debitCard.getCardHolderName());
        response.setCardStatus(debitCard.getCardStatus());
        response.setExpiryMonth(debitCard.getExpiryMonth());
        response.setExpiryYear(debitCard.getExpiryYear());
        response.setDeliveryMode(debitCard.getDeliveryMode());
        response.setTrackingNumber(debitCard.getTrackingNumber());

        return response;
    }
    @Override
    public DebitCardUpdateResponse updateDebitCardRequest(Long accountId,
                                                          Long debitCardId,
                                                          DebitCardUpdateRequest request) {

        AccountDebitCard debitCard = debitCardRepository
                .findByAccount_AccountIdAndDebitCardId(accountId, debitCardId)
                .orElseThrow(() -> new DebitCardException(
                        "CARD_404",
                        "Debit card request not found."));

        // Cannot update after card is printed
        if ("PRINTED".equalsIgnoreCase(debitCard.getCardStatus())) {
            throw new DebitCardException(
                    "CARD_400",
                    "Debit card request cannot be updated after card is printed.");
        }

        // Update delivery mode
        debitCard.setDeliveryMode(request.getDeliveryMode());

        // Update dispatch address
        if (request.getDispatchAddress() != null) {
            debitCard.setDispatchAddress(
                    serializeAddress(request.getDispatchAddress()));
        }

        // Update remarks
        debitCard.setRemarks(request.getRemarks());

        // Audit fields
        debitCard.setUpdatedBy("SYSTEM"); // or logged-in user
        debitCard.setUpdatedDate(LocalDateTime.now());

        debitCardRepository.save(debitCard);

        DebitCardUpdateResponse response = new DebitCardUpdateResponse();
        response.setStatus("SUCCESS");
        response.setMessage("Debit card request updated successfully.");

        return response;
        
    }
    
}

