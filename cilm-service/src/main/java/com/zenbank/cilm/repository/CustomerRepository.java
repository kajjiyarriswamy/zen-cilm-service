package com.zenbank.cilm.repository;

import com.zenbank.cilm.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    
    @Query(""" 
    		select c from Customer c
    		where (:customerId IS NULL OR c.id= :customerId)
    		AND (:cif IS NULL OR c.cif_number =  :cif)
    		AND (:phoneNumber IS NULL OR c.phoneNumber = :phoneNumber)
    		AND (:pan IS NULL OR c.panNumber = :pan)
    		AND (:aadhaar IS NULL OR c.aadhaarNumber = :aadhaar)
    		AND (:status IS NULL OR c.customerStatus = :status)
    		""")

	Page<Customer> searchCustomer(
			@Param("customerId") Long customerId, 
			@Param("cif")String cif, 
			@Param("phoneNumber") String phoneNumber, 
			@Param("pan")String pan, 
			@Param("aadhaar")String aadhaar,
			@Param("status")String status, 
			Pageable pageable);
}
