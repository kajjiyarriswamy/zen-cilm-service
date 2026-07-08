package com.zenbank.cilm.repository;

import com.zenbank.cilm.entity.CustomerAudit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CustomerAuditRepository extends JpaRepository<CustomerAudit, Long> {

    @Query("SELECT a FROM CustomerAudit a WHERE a.customer.customerId = :customerId " +
            "AND (:action IS NULL OR a.action = :action) " +
            "AND (:performedBy IS NULL OR a.performedBy = :performedBy) " +
            "AND (:fromDate IS NULL OR a.createdDate >= :fromDate) " +
            "AND (:toDate IS NULL OR a.createdDate <= :toDate) " +
            "ORDER BY a.createdDate DESC")
    Page<CustomerAudit> searchAudit(@Param("customerId") String customerId,
                                    @Param("action") String action,
                                    @Param("performedBy") String performedBy,
                                    @Param("fromDate") LocalDateTime fromDate,
                                    @Param("toDate") LocalDateTime toDate,
                                    Pageable pageable);

    Optional<CustomerAudit> findByAuditIdAndCustomer_CustomerId(Long auditId, String customerId);
}

