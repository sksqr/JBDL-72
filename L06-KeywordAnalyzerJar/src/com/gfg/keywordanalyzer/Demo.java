package com.gfg.keywordanalyzer;

public class Demo {


    public static void main(String[] args) {

        //KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerImpl();
       // KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImp();
        //KeywordAnalyzerInterface keywordAnalyzer = new FreqKeywordAnalyzerImpl();

        KeywordAnalyzerInterface keywordAnalyzer = new KeywordAnalyzerOrderByFreq();

        keywordAnalyzer.recordKeyword("lap2top");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("lapaop");
        keywordAnalyzer.recordKeyword("mobile");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("phone");
        keywordAnalyzer.recordKeyword("laptop");
        keywordAnalyzer.recordKeyword("Acer Laptop");

        System.out.println(keywordAnalyzer.getKeywords());
        System.out.println(keywordAnalyzer.getKeywordFreqOrderByFreq());
        System.out.println(keywordAnalyzer.getKeywordWithFreq());

    }
}
