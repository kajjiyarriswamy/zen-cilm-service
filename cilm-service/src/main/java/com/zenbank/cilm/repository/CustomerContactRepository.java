package com.zenbank.cilm.repository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;
import com.zenbank.cilm.entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);

    Optional<CustomerContact> findByCustomer(Customer customer);
    
    List<CustomerContact> findByCustomerCustomerId(String customerId);
    
    
    
}