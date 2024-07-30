package com.codegym.furama.service.service;

import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.ServiceType;
import com.codegym.furama.repository.service.IRentTypeRepository;
import com.codegym.furama.repository.service.IServiceRepository;
import com.codegym.furama.repository.service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImlp implements IService{
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public List<ServiceType> findServiceType() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findRentType() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public List<com.codegym.furama.model.service.Service> getList() {
        return iServiceRepository.findAll();
    }

    @Override
    public com.codegym.furama.model.service.Service add(com.codegym.furama.model.service.Service service) {
        try{
            return  iServiceRepository.save(service);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public com.codegym.furama.model.service.Service update(com.codegym.furama.model.service.Service service) {
        try{

            return iServiceRepository.save(service);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<com.codegym.furama.model.service.Service> findPage(Pageable pageable) {
        return iServiceRepository.findPage(pageable);
    }

    @Override
    public List<com.codegym.furama.model.service.Service> getService(String service) {
        return iServiceRepository.findAll();
    }

    @Override
    public List<com.codegym.furama.model.service.Service> findByServiceName(String service) {
        return iServiceRepository.findByServiceName("%" + service + "%");
    }

    @Override
    public com.codegym.furama.model.service.Service findById(int id) {
        return iServiceRepository.findById(id).get();
    }

    @Override
    public boolean delete(int id) {
        try {
            iServiceRepository.deleteContractByService(id);
            iServiceRepository.deleteService(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
