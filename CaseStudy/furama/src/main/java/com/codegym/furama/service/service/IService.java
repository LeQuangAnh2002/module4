package com.codegym.furama.service.service;

import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.Service;
import com.codegym.furama.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
    List<ServiceType> findServiceType();
    List<RentType> findRentType();
    List<Service> getList();
    Service add(Service service);
    Service update(Service service);
    Page<Service> findPage(Pageable pageable);
    List<Service> getService(String service);

    List<Service> findByServiceName(String service);

    Service findById(int id);
    boolean delete(int id);
}
