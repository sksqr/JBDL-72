package com.example.L09_JDBC_demo.dao;

import com.example.L09_JDBC_demo.entity.Product;

public interface ProductDAOInterface {

    Product getById(Long id);

    Product create(Product product);

    Product update(Long id, Product product);

    Product delete(Long id);
}
