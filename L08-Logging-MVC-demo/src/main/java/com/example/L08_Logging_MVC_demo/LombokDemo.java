package com.example.L08_Logging_MVC_demo;

public class LombokDemo {

    public static void main(String[] args) {
        Product product = new Product(1l,"Mouse",100.00);
        product.setName("Laptop");
        System.out.println(product);

    }
}
