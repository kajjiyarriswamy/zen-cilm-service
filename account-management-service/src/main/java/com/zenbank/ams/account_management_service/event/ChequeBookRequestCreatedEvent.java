package com.zenbank.ams.account_management_service.event;

public class ChequeBookRequestCreatedEvent {

    private final Long accountId;
    private final Long chequeBookRequestId;
    private final String customerId;
    private final String accountNumber;
    private final String requestStatus;
    private final String deliveryMode;
    private final String deliveryAddress;

    public ChequeBookRequestCreatedEvent(Long accountId, Long chequeBookRequestId, String customerId,
            String accountNumber, String requestStatus, String deliveryMode, String deliveryAddress) {
        this.accountId = accountId;
        this.chequeBookRequestId = chequeBookRequestId;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.requestStatus = requestStatus;
        this.deliveryMode = deliveryMode;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getChequeBookRequestId() {
        return chequeBookRequestId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
