package com.example.L09_JDBC_demo.service;

import com.example.L09_JDBC_demo.dao.ProductDAO;
import com.example.L09_JDBC_demo.dao.ProductDAOInterface;
import com.example.L09_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productDAOWithDB")
    private ProductDAOInterface productDAOService;

    public Product getById(Long id){
        return productDAOService.getById(id);
    }

    public Product create(Product product){
        return productDAOService.create(product);
    }

    public Product update(Long id, Product product){
        return productDAOService.update(id,product);
    }

    public Product delete(Long id){
        return productDAOService.delete(id);
    }
}
