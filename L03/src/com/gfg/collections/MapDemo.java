package com.gfg.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {


    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        map.put("batch","JBDL-72");
        map.put("mentor","Shashi");

        System.out.println(map);
    }
}
