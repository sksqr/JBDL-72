package com.gfg.exceptions;

import java.util.List;

public class SearchService {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> data=null;

        try {
            data =productService.getProduct("Laptop");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Close all resources");
        }


        System.out.println(data);
    }


}
