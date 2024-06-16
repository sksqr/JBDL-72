package org.gfg.keywords.keywordanalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordAnalyzerOrderByFreq implements KeywordAnalyzerInterface{

    Map<String,KeywordFreq> dataStore = new HashMap<>();

    @Override
    public void recordKeyword(String keyword) {
        if(dataStore.keySet().contains(keyword)){
            dataStore.get(keyword).increment();
        }
        else{
            dataStore.put(keyword,new KeywordFreq(keyword,1));
        }
    }

    @Override
    public List<String> getKeywords() {
        return dataStore.keySet().stream().toList();
    }

    @Override
    public Map<String, Integer> getKeywordWithFreq() {
        return null;
    }

    @Override
    public List<KeywordFreq> getKeywordFreqOrderByFreq() {
        //return dataStore.values().stream().sorted().toList();
        return dataStore.values().stream().sorted((o1, o2) ->  o2.getFreq() - o1.getFreq()).toList();
    }
}
