package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService{
    private static  final Map<String,Product> listProducts;

    static {
        listProducts = new HashMap<>();
        listProducts.put("1",new Product("1","Iphone12","2000","Tốt","Iphone"));
        listProducts.put("2",new Product("2","S20 Utra","4000","Tốt","SamSung"));
        listProducts.put("3",new Product("3","Oppo S7","5000","Tốt","Oppo"));
        listProducts.put("4",new Product("4","Iphone15 Pro Max","3000","Tốt","Iphone"));
    }
    @Override
    public void add(Product product) {
        if (!listProducts.containsKey(product.getId())) {
            listProducts.put(product.getId(),product);
        }
    }

    @Override
    public void update(String id, Product product) {
        if (listProducts.containsKey(product.getId())) {
            listProducts.put(product.getId(),product);
        }
    }

    @Override
    public void delete(String id) {
        listProducts.remove(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProducts.values());
    }

    @Override
    public Product findByID(String id) {
        return listProducts.get(id);
    }
}
