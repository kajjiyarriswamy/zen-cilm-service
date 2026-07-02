package com.zenbank.cilm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerNominee;

public interface CustomerNomineeRepository extends JpaRepository<CustomerNominee, Long> {

    List<CustomerNominee> findByCustomer(Customer customer);

}


