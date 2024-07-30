package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "SELECT * FROM contract " +
            " JOIN customer ON customer.customer_id = contract.contract_id " +
            " JOIN employee ON employee.employee_id = contract.employee_id " +
            " JOIN service On service.service_id = contract.service_id ",nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);
    @Query(value = "SELECT MAX(contract.contract_id) FROM contract",nativeQuery = true)
    Long showMaxId();
}
