package com.gfg.collections.keywordanalyzer;

import java.util.*;

public class UniqueKeywordAnalyzerImp implements KeywordAnalyzerInterface{

    //private Set<String> dataStore = new HashSet<>();

    //private Set<String> dataStore = new LinkedHashSet<>();

    //private Set<String> dataStore = new TreeSet<>();

    private Set<String> dataStore = new TreeSet<>(Comparator.reverseOrder());

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getKeywords() {
        return dataStore.stream().toList();
    }
}
