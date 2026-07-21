package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface AccountChequeBookRequestRepository extends JpaRepository<AccountChequeBookRequest, Long> {

    boolean existsByAccountIdAndRequestStatusIn(Long accountId, Collection<String> requestStatuses);

//    Optional<AccountChequeBookRequest> findByChequeBookId(Long chequeBookId);
    Optional<AccountChequeBookRequest> findByAccountIdAndChequeBookId(
            Long accountId,
            Long chequeBookId);
}
