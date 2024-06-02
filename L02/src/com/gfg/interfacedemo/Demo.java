package com.gfg.interfacedemo;

public class Demo {

    public static void main(String[] args) {

        TataTiago tataTiago = new TataTiago();
        System.out.println(tataTiago.getRC());
        System.out.println(tataTiago.getCompanyName());


        TataCar tataCar = new TataPunch();
        System.out.println(tataCar.getRC());
        System.out.println(tataCar.getMusicSystem());
    }
}
