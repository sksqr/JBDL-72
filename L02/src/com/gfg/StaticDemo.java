package com.gfg;

import java.util.Scanner;

public class StaticDemo {
    public static void main(String[] args) {
        //Laptop.start();
        //Laptop.toString();

        System.out.println(Laptop.laptopCount);
        System.out.println(Laptop.designData());


        Laptop laptop = new Laptop("Win11", "i5");
        laptop.start();

        Laptop laptop2 = new Laptop("Win11", "i5");
        laptop2.start();

        Laptop laptop3 = new Laptop("Win11", "i5");
        laptop3.start();

        System.out.println(Laptop.laptopCount);
        System.out.println(laptop.laptopCount);
        System.out.println(laptop.designData());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to exit");
        String data = scanner.nextLine();

    }
}
