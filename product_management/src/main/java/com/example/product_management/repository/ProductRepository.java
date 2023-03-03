package com.example.product_management.repository;


import com.example.product_management.model.Product;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> products = entityManager.createQuery("from Product where name like concat('%',:name,'%') ").setParameter("name", search).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.find(Product.class, id);
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setProducer(product.getProducer());
        entityManager.merge(product1);
    }

    @Override
    public void remove(int id) {
        entityManager.find(Product.class, id);
        entityManager.remove(id);
    }
}


