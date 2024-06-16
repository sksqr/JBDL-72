package org.keyword.client;

import com.gfg.keywordanalyzer.KeywordAnalyzerImpl;
import com.gfg.keywordanalyzer.KeywordAnalyzerInterface;
import com.gfg.keywordanalyzer.NewKeywordAnalyzerImpl;

public class ClientDemo {

    public static void main(String[] args) {
        //KeywordAnalyzerInterface keywordAnalyzerInterface = new KeywordAnalyzerImpl();
        KeywordAnalyzerInterface keywordAnalyzerInterface = new NewKeywordAnalyzerImpl();
    }
}
