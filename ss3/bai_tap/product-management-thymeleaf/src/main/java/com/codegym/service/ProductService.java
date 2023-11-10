package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void update(String id,Product product);
    void delete(String id);
    List<Product> findAll();
    Product findByID(String id);

}
