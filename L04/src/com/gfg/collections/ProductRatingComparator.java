package com.gfg.collections;

import java.util.Comparator;

public class ProductRatingComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getRating().compareTo(o2.getRating());
    }
}
