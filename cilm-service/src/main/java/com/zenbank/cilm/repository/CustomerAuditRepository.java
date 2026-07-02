package com.zenbank.cilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.CustomerAudit;

public interface CustomerAuditRepository extends JpaRepository<CustomerAudit, Long> {

}
