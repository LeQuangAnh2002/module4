package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findPage(Pageable pageable);

    List<CustomerType> findCustomerType();
    List<Customer> getList();
    Customer add(Customer customer);
    boolean remove(int id);
    Customer update(Customer customer);
    Page<Customer> findByName(Pageable pageable,String name);
    List<Customer> getCustomer();
    Customer findById(int id);
}
