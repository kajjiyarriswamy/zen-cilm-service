package com.zenbank.deposit_service.repository;


import com.zenbank.deposit_service.entity.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Long> {
}

