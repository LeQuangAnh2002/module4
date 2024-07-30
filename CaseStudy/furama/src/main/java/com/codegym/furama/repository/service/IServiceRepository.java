package com.codegym.furama.repository.service;

import com.codegym.furama.model.service.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findPage(Pageable pageable);

    List<Service> findByServiceName(@Param("service") String service);
    void deleteService(@Param("id") int id) throws DataAccessException;

    void deleteContractByService(@Param("id") int id) throws DataAccessException;
}
