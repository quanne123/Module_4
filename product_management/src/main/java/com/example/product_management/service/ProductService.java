package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer,Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"May bay","Vip"));
        products.put(2,new Product(2,"May Giat","Vip"));
        products.put(3,new Product(3,"One Piece","Vip"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }
}
