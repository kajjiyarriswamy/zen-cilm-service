package com.zenbank.cilm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerDocument;

public interface CustomerDocumentRepository extends JpaRepository<CustomerDocument, Long>{
	List<CustomerDocument> findByCustomer(Customer customer);

}
