package com.zenbank.ams.account_management_service.repository;

import com.zenbank.ams.account_management_service.entity.AccountChequeBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public interface AccountChequeBookRequestRepository extends JpaRepository<AccountChequeBookRequest, Long>, JpaSpecificationExecutor<AccountChequeBookRequest> {

    boolean existsByAccountIdAndRequestStatusIn(Long accountId, Collection<String> requestStatuses);

//    Optional<AccountChequeBookRequest> findByChequeBookId(Long chequeBookId);
    Optional<AccountChequeBookRequest> findByAccountIdAndChequeBookId(
            Long accountId,
            Long chequeBookId);

    @Query("""
            SELECT c
            FROM AccountChequeBookRequest c
            WHERE
                (:accountNumber IS NULL OR c.accountNumber = :accountNumber)
            AND (:customerId IS NULL OR c.customerId = :customerId)
            AND (:requestStatus IS NULL OR c.requestStatus = :requestStatus)
            AND (:chequeBookType IS NULL OR c.chequeBookType = :chequeBookType)
            AND (:requestMode IS NULL OR c.requestMode = :requestMode)
            AND (:fromDate IS NULL OR c.createdDate >= :fromDate)
            AND (:toDate IS NULL OR c.createdDate <= :toDate)
            ORDER BY c.createdDate DESC
            """)
    Page<AccountChequeBookRequest> searchChequeBookRequests(

            @Param("accountNumber") String accountNumber,

            @Param("customerId") String customerId,

            @Param("requestStatus") String requestStatus,

            @Param("chequeBookType") String chequeBookType,

            @Param("requestMode") String requestMode,

            @Param("fromDate") LocalDateTime fromDate,

            @Param("toDate") LocalDateTime toDate,

            Pageable pageable);

}
