package com.zenbank.cilm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerNominee;

@Repository
public interface CustomerNomineeRepository extends JpaRepository<CustomerNominee, Long> {

	Optional<CustomerNominee> findByNomineeIdAndCustomerId(Long nomineeId, Customer customer);
	
	

}
