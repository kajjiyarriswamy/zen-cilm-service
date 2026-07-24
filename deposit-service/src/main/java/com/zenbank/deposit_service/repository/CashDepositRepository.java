package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.deposit_service.entity.CashDeposit;
@Repository
public interface CashDepositRepository extends JpaRepository<CashDeposit, Long> {

}
