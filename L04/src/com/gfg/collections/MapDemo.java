package com.gfg.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {


    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("batch","JBDL-72");
        map.put("mentor","Shashi");
        System.out.println(map);

        System.out.println("--------");
        Map<Integer,Product> productMap = new HashMap<>();
        Product product1 = new Product("laptop",50000.00,4);
        Product product2 = new Product("pen",50.00,5);
        Product product3 = new Product("mouse",500.00,1);
        Product product4 = new Product("monitor",10000.00,3);

        productMap.put(21,product1);
        productMap.put(32,product2);
        productMap.put(46,product3);
        System.out.println(productMap);
        productMap.put(46,product4);
        System.out.println("--------");
        System.out.println(productMap);
        productMap.put(56,product1);
        System.out.println("--------");
        System.out.println(productMap);

        System.out.println("--------");
        System.out.println(productMap.get(32));

        System.out.println("--------");
        for(Integer key : productMap.keySet()){
            System.out.println(productMap.get(key));
        }

        System.out.println("--------");
        for (Product product : productMap.values()){
            System.out.println(product);
        }

    }
}
