package com.example.L08_Logging_MVC_demo;

import jakarta.annotation.PostConstruct;
import org.gfg.keywords.keywordanalyzer.KeywordAnalyzerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private Map<Long,Product> productMap;
    private AtomicLong nextId= new AtomicLong(1);

    @Autowired
    @Qualifier("keywordAnalyzerImpl")
    private KeywordAnalyzerInterface keywordAnalyzer;

    @PostConstruct
    public void initMethod(){
        productMap = new HashMap<>();
        productMap.put(nextId.getAndIncrement(), new Product(1l,"Laptop",50000.00));
        productMap.put(nextId.getAndIncrement(), new Product(2l,"Mouse",500.00));
        productMap.put(nextId.getAndIncrement(), new Product(3l,"Keyboard",1000.00));
    }

    public Product getProdById(Long id){
        return productMap.get(id);
    }

    public Product createProduct(Product product){
        product.setId(nextId.getAndIncrement());
        productMap.put(product.getId(),product);
        return product;
    }

    public List<Product> searchProduct(String keyword){
        //
        keywordAnalyzer.recordKeyword(keyword);
        List<Product> productList = new ArrayList<>();
        for(Product product: productMap.values()){
            if(product.getName().equalsIgnoreCase(keyword)){
                productList.add(product);
            }
        }
        return productList;
    }
}
