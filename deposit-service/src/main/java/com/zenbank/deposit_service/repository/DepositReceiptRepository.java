package com.zenbank.deposit_service.repository;

import com.zenbank.deposit_service.entity.DepositReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositReceiptRepository extends JpaRepository<DepositReceipt, Long> {
}
