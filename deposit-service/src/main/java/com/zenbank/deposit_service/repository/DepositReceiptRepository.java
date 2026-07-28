package com.zenbank.deposit_service.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.deposit_service.entity.DepositReceipt;

@Repository
public interface DepositReceiptRepository extends JpaRepository<DepositReceipt, Long> {

    Optional<DepositReceipt> findByReceiptNumber(String receiptNumber);

    boolean existsByReceiptNumber(String receiptNumber);
}
