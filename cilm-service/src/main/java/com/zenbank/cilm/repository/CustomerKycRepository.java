package com.zenbank.cilm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerKyc;

public interface CustomerKycRepository  extends JpaRepository<CustomerKyc,Long>{
	Optional<CustomerKyc> findByCustomer(Customer customer);
}
//public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Long> {
//	
//	Optional<CustomerKyc> findByCustomer(Customer customer);
//}
