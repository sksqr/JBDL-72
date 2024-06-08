package com.gfg.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> getProduct(String keyword) throws ProductNotFoundException{
        //Call to Db
        if(keyword == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        System.out.println("Calling DB");
        List<Product> list = new ArrayList<>();
        if(list.isEmpty()){
            throw new ProductNotFoundException("No product for keyword:"+keyword);
        }
        return list;
    }
}
