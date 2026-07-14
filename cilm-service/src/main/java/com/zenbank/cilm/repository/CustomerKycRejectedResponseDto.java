package com.zenbank.cilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.Customer;

public interface CustomerKycRejectedResponseDto extends JpaRepository<Customer, Long> {

}
