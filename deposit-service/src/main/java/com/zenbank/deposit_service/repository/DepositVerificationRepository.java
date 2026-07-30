package com.zenbank.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.deposit_service.entity.DepositVerification;

public interface DepositVerificationRepository extends JpaRepository<DepositVerification, Long>{

}
