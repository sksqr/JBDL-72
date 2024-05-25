package org.gfg.demo;

import java.util.Scanner;

public class ClassObjectDemo {

    public static void main(String[] args) {

        Lecture l0 = new Lecture();
        l0.setName("L0");
        l0.setMentor("Shashi");
        l0.setStatus("Live");

        Scanner sc = new Scanner(System.in);
        System.out.println("enter something");
        String data = sc.nextLine();
        System.out.println(data);

        Lecture l1 = new Lecture();
        l1.setName("L01");
        l1.setMentor("Shashi");
        l1.setStatus("Upcoming");


        System.out.println("enter something");
        data = sc.nextLine();
        System.out.println(data);

        System.out.println(l0);
        System.out.println(l1);

        System.out.println(l0.getMentor().hashCode());
        System.out.println(l1.getMentor().hashCode());


    }
}
