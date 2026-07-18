package com.zenbank.cilm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerContact;
import com.zenbank.cilm.entity.CustomerPreferences;


public interface CustomerPreferencesRepository extends JpaRepository<CustomerPreferences, Long> {
	
    // Optional<CustomerPreferences> findByCustomer(Customer customer);
     
     Optional<CustomerPreferences> findByCustomerCustomerId(String customerId);
    
    //List<CustomerContact> findByCustomerCustomerId(String customerId);
    

	
	

}
