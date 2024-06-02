package com.gfg;

import com.gfg.interfacedemo.TataCar;
import com.gfg.interfacedemo.TataPunch;
import com.gfg.interfacedemo.TataTiago;

import java.util.Scanner;

public class PolymorphismDemo {


    public static void main(String[] args) {


        //Compile time Polymorphism
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println(areaCalculator.area(10.00));
        System.out.println(areaCalculator.area(10.00,2.00));

        //Runtime Polymorphism
        TataCar tataCar = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("tiago")){
            tataCar = new TataTiago();
        }
        else {
            tataCar = new TataPunch();
        }
        System.out.println(tataCar.getRC());
        System.out.println(tataCar.getMusicSystem());


    }
}
