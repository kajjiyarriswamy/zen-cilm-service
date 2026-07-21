package com.zenbank.ams.account_management_service.specification;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountChequeBookRequestSpecification {

    private AccountChequeBookRequestSpecification() {
    }

    public static Specification<AccountChequeBookRequest> searchChequeBookRequests(
            String accountNumber,
            String customerId,
            String requestStatus,
            String chequeBookType,
            String requestMode,
            LocalDate fromDate,
            LocalDate toDate) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Account Number
            if (accountNumber != null && !accountNumber.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("accountNumber"),
                        accountNumber));
            }

            // Customer ID
            if (customerId != null && !customerId.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("customerId"),
                        customerId));
            }

            // Request Status
            if (requestStatus != null && !requestStatus.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("requestStatus"),
                        requestStatus));
            }

            // Cheque Book Type
            if (chequeBookType != null && !chequeBookType.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("chequeBookType"),
                        chequeBookType));
            }

            // Request Mode
            if (requestMode != null && !requestMode.isBlank()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("requestMode"),
                        requestMode));
            }

            // From Date
            if (fromDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("createdDate"),
                        fromDate.atStartOfDay()));
            }

            // To Date
            if (toDate != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("createdDate"),
                        toDate.atTime(23, 59, 59)));
            }

            query.orderBy(criteriaBuilder.desc(root.get("createdDate")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
