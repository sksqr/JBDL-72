package com.gfg;

import java.util.ArrayList;
import java.util.List;

public class SearchProductServiceWithComposition  {

    private SortingAlgoInterface sortingAlgo;

    private FormattingService formattingService;

    //

    //

    //Tightly Coupled
    public SearchProductServiceWithComposition() {
        sortingAlgo = new MergeSortAlgo();
        formattingService = new FormattingService();
    }


    //loosely Coupled
    public SearchProductServiceWithComposition(SortingAlgoInterface sortingAlgo) {
        this.sortingAlgo = sortingAlgo;
        formattingService = new FormattingService();
    }

    public List<String> search(String keyword){
        /*
        fetch from DB
         */
        List<String> products = new ArrayList<>();
        //sorting
        sortingAlgo.sort(products);
        formattingService.format();
        return products;
    }
}
