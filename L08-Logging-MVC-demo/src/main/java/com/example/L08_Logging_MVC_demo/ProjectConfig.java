package com.example.L08_Logging_MVC_demo;

import org.gfg.keywords.keywordanalyzer.KeywordAnalyzerImpl;
import org.gfg.keywords.keywordanalyzer.KeywordAnalyzerInterface;
import org.gfg.keywords.keywordanalyzer.KeywordAnalyzerOrderByFreq;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {


    @Bean
    public KeywordAnalyzerInterface keywordAnalyzerImpl(){
        return new KeywordAnalyzerImpl();
    }


    @Bean
    @Primary
    public KeywordAnalyzerInterface keywordAnalyzerOrderByFreq(){
        return new KeywordAnalyzerOrderByFreq();
    }
}
