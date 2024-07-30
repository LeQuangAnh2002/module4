package com.codegym.furama.model.service;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private int id;
    private String name;
    private double cost;

    @OneToMany(mappedBy = "rentType")
    List<Service> rentTypes;

    public RentType() {
    }

    public RentType(int id, String name, double cost, List<Service> rentTypes) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.rentTypes = rentTypes;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Service> getRentTypes() {
        return rentTypes;
    }

    public void setRentTypes(List<Service> rentTypes) {
        this.rentTypes = rentTypes;
    }
}
