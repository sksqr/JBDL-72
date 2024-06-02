package com.gfg;

public class ObjectClassDemo {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Ununtu", "i5 8th Gen");
        Laptop laptop2 = new Laptop("Ununtu", "i5 8th Gen");
        Laptop laptop3 = laptop1;

        System.out.println(laptop1.toString());
        System.out.println(laptop1);//com.gfg.Laptop@30f39991

        System.out.println(laptop1.equals(laptop2));
        System.out.println(laptop1.equals(laptop3));

        String data1 = new String("Chair");
        String data2 = new String("Chair");

        System.out.println(data1.equals(data2)); // String overrides equals method of object class
        System.out.println(data1 ==  data2); // reference comparison





    }
}
