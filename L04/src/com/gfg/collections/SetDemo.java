package com.gfg.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        List<String> studentsList = new ArrayList<>();
        studentsList.add("Neeraj");
        studentsList.add("Deeraj");
        studentsList.add("Deeraj");
        System.out.println(studentsList);

        Set<String> studentsSet = new HashSet<>();
        studentsSet.add("Neeraj");
        studentsSet.add("Deeraj");
        studentsSet.add("Deeraj");
        studentsSet.add("Neeraj");
        System.out.println(studentsSet);
        System.out.println(studentsSet.size());
        System.out.println("----------");
        Product product1 = new Product("laptop",50000.00,4);
        Product product2 = new Product("pen",50.00,5);
        Product product3 = new Product("mouse",500.00,1);
        Product product4 = new Product("mouse",500.00,1);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        System.out.println(product3.equals(product4));
        System.out.println(productSet.size());


    }
}
