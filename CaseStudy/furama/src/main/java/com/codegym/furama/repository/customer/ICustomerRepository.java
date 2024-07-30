package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable pageable);


    Page<Customer> findByName(Pageable pageable, @Param("name") String name);


    @Modifying
    @Transactional
    void deleteContractByCustomer(@Param("id") int id);

    @Modifying
    @Transactional
    void deleteCustomer(@Param("id") int id);
}
