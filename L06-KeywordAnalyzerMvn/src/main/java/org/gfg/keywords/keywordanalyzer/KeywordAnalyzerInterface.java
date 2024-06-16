package org.gfg.keywords.keywordanalyzer;

import java.util.List;
import java.util.Map;

public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getKeywords();

    default Map<String,Integer> getKeywordWithFreq(){
        return null;
    }

    default List<KeywordFreq> getKeywordFreqOrderByFreq(){
        return null;
    }
}
