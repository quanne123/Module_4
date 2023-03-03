package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String search);

    void save(Product product);

    Product findById(int id);

    void update(int id,Product product);

    void remove(int id);
}
