package com.zenbank.cilm.repository;

import com.zenbank.cilm.entity.CustomerAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAuditRepository extends JpaRepository<CustomerAudit, Long> {
}