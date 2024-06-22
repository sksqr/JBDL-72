package org.gfg.didemo;

import java.util.ArrayList;
import java.util.List;

public class JobListingService {

    private TranslationService translationService;

    public JobListingService() {
        translationService = new TranslationService();
    }

    public JobListingService(TranslationService translationService) {
        this.translationService = translationService;
    }

    List<String> getAllJobsByKeyword(String key){
        List<String> result = new ArrayList<>();
        // call to DB
        // to transaction
        result = translationService.translate(result);
        return result;
    }
}
