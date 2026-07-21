package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.Optional;

public interface AccountChequeBookRequestRepository extends JpaRepository<AccountChequeBookRequest, Long>, JpaSpecificationExecutor<AccountChequeBookRequest> {

    boolean existsByAccountIdAndRequestStatusIn(Long accountId, Collection<String> requestStatuses);

//    Optional<AccountChequeBookRequest> findByChequeBookId(Long chequeBookId);
    Optional<AccountChequeBookRequest> findByAccountIdAndChequeBookId(
            Long accountId,
            Long chequeBookId);
}
