package com.example.L08_restfull_services_demo.dao;

import com.example.L08_restfull_services_demo.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

//@Component
@Repository
public class ProductDAO {

    private Map<Long,Product> dataStore = new HashMap<>();
    private AtomicLong nextId=new AtomicLong(1l);

    public Product getById(Long id){
        // call DB
        return dataStore.get(id);
    }

    public Product create(Product product){
        product.setId(nextId.getAndIncrement());
        dataStore.put(product.getId(),product);
        return product;
    }

    public Product update(Long id, Product product){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct==null){
            return null;
        }
        exitingProduct.setName(product.getName());
        exitingProduct.setCost(product.getCost());
        return exitingProduct;
    }

    public Product delete(Long id){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct==null){
            return null;
        }
        dataStore.remove(id);
        return exitingProduct;
    }
}
