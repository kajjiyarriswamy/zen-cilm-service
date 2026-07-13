package com.zenbank.cilm.repository;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerContact;
=======
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;
import com.zenbank.cilm.entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
>>>>>>> origin/main

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);

    Optional<CustomerContact> findByCustomer_CustomerId(String customerId);

    Optional<CustomerContact> findByCustomer(Customer customer);
<<<<<<< HEAD

=======
    
    List<CustomerContact> findByCustomerCustomerId(String customerId);
    
>>>>>>> origin/main
}