package com.zenbank.deposit_service.repository;

import com.zenbank.deposit_service.entity.DepositAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositAuditRepository extends JpaRepository<DepositAudit, Long> {
}
