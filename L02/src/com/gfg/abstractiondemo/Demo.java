package com.gfg.abstractiondemo;

import com.gfg.interfacedemo.IndGovtNormsForCar;
import com.gfg.interfacedemo.TataCar;
import com.gfg.interfacedemo.TataTiago;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Data output");

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(-2);
        list.add(20);
        list.add(7);
        list.add(1);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

//        TataCar tataCar = new TataCar();
        TataCar tataCar1 = new TataTiago();
        TataTiago tataTiago = new TataTiago();

        IndGovtNormsForCar indGovtNormsForCar = new TataTiago();
//        IndGovtNormsForCar indGovtNormsForCar = new TataCar();
//        IndGovtNormsForCar indGovtNormsForCar = new IndGovtNormsForCar();

        //Anonymous Class
        TataCar tataCar = new TataCar() {
            @Override
            public String getPUC() {
                return null;
            }

            @Override
            public String getRC() {
                return null;
            }

            @Override
            public String getInsurance() {
                return null;
            }
        };

        //Anonymous Class
        TataCar tataCar2 = new TataCar() {
            @Override
            public String getPUC() {
                return null;
            }

            @Override
            public String getRC() {
                return null;
            }

            @Override
            public String getInsurance() {
                return null;
            }
        };

        System.out.println(tataCar);
        tataCar2.getPUC();
    }
}
