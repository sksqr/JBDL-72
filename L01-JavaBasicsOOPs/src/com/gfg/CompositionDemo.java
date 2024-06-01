package com.gfg;

public class CompositionDemo {
    public static void main(String[] args) {


        SearchProductServiceWithComposition searchProductServiceWithComposition = new SearchProductServiceWithComposition(new BubbleSortAlgo());
        searchProductServiceWithComposition.search("laptop");

        SearchProductServiceWithComposition searchProductService = new SearchProductServiceWithComposition(new MergeSortAlgo());
        searchProductService.search("laptop");
    }
}
