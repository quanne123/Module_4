package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll(String search) {
        return productRepository.findAll(search);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
