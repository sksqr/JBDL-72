package com.gfg.collections.keywordanalyzer;

import java.util.List;

public class DummyImp implements KeywordAnalyzerInterface{
    @Override
    public void recordKeyword(String keyword) {

    }

    @Override
    public List<String> getKeywords() {
        return List.of();
    }
}
