package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.entity.ChequeDeposit;

public interface ChequeDepositRepository extends JpaRepository<ChequeDeposit, Long> {

}
