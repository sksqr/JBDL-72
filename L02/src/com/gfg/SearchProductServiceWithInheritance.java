package com.gfg;

import java.util.ArrayList;
import java.util.List;

public class SearchProductServiceWithInheritance extends MergeSortAlgo{

    public List<String> search(String keyword){
        /*
        fetch from DB
         */
        List<String> products = new ArrayList<>();
        //sorting
        sort(products);
//        super.sort(products);
        return products;
    }

    public List<String> search(String keyword, List<String> filters){
        /*
        fetch from DB
         */
        List<String> products = new ArrayList<>();
        //sorting
        sort(products);
//        super.sort(products);
        return products;
    }

//    @Override
//    public void sort(List<String> list) {
//
//    }

}
