package com.zenbank.cilm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;

@Repository
public interface AddressRepository extends JpaRepository<CustomerAddress, Long> {

	List<CustomerAddress> findByCustomer_CustomerId(String customerId);

	boolean existsByCustomer_CustomerId(String customerId);

    Optional<CustomerAddress> findByAddressId(Long addressId);


    boolean existsByCustomerAndIsPrimaryTrue(Customer customer);

}