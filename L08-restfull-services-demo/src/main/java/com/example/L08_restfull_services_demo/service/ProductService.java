package com.example.L08_restfull_services_demo.service;

import com.example.L08_restfull_services_demo.dao.ProductDAO;
import com.example.L08_restfull_services_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product getById(Long id){
        return productDAO.getById(id);
    }

    public Product create(Product product){
        return productDAO.create(product);
    }

    public Product update(Long id, Product product){
        return productDAO.update(id,product);
    }

    public Product delete(Long id){
        return productDAO.delete(id);
    }
}
