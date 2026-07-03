package com.zenbank.cilm.repository;


import com.zenbank.cilm.dto.AddressResponseDto;
import com.zenbank.cilm.entity.Customer;
import com.zenbank.cilm.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<CustomerAddress, Long> {
    boolean existsByCustomerAndIsPrimaryTrue(Customer customer);

}
