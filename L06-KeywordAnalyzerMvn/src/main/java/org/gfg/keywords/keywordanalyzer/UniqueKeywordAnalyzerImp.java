package org.gfg.keywords.keywordanalyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
