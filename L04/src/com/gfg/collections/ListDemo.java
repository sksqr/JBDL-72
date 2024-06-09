package com.gfg.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

//        List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList = new LinkedList<>();

        integerList.add(2);
        integerList.add(5);
        integerList.add(15);

        System.out.println(integerList);

        System.out.println(integerList.get(1));

    }
}
