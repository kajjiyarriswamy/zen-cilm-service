package com.zenbank.ams.account_management_service.dto;

import java.util.List;

public class AccountChequeBookSearchResponseDto {

    private String status;

    private Integer page;

    private Integer size;

    private Long totalRecords;

    private List<SearchData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<SearchData> getData() {
        return data;
    }

    public void setData(List<SearchData> data) {
        this.data = data;
    }

    public static class SearchData {

        private String chequeBookRequestId;

        private String accountNumber;

        private String chequeBookType;

        private Integer leavesCount;

        private String requestStatus;

        private String requestMode;

        public String getChequeBookRequestId() {
            return chequeBookRequestId;
        }

        public void setChequeBookRequestId(String chequeBookRequestId) {
            this.chequeBookRequestId = chequeBookRequestId;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getChequeBookType() {
            return chequeBookType;
        }

        public void setChequeBookType(String chequeBookType) {
            this.chequeBookType = chequeBookType;
        }

        public Integer getLeavesCount() {
            return leavesCount;
        }

        public void setLeavesCount(Integer leavesCount) {
            this.leavesCount = leavesCount;
        }

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public String getRequestMode() {
            return requestMode;
        }

        public void setRequestMode(String requestMode) {
            this.requestMode = requestMode;
        }
    }
}
