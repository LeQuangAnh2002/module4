package com.codegym.furama.model.service;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    List<Service> serviceTypes;

    public ServiceType() {
    }

    public ServiceType(int id, String name, List<Service> serviceTypes) {
        this.id = id;
        this.name = name;
        this.serviceTypes = serviceTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<Service> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }
}
