package com.gfg.finaldemo;

import com.gfg.interfacedemo.TataCar;
import com.gfg.interfacedemo.TataPunch;
import com.gfg.interfacedemo.TataTiago;

import java.util.Date;
import java.util.PriorityQueue;

public class FinalDemo {

    private static String lecture = "02";
    public static final double pi = 3.14;

    private static final TataCar tataCar = new TataTiago();

    private static final Date date = new Date();

    public static void main(String[] args) {
        lecture = "03";
        //pi = 22/7;
        //tataCar = new TataPunch();
        System.out.println(date);
        //date = new Date(4378756645l);
        date.setTime(48765435678l);
        System.out.println(date);

    }
}
