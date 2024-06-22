package org.gfg.didemo;

import java.util.ArrayList;
import java.util.List;

public class JobDetailService {

    private TranslationService translationService;

    public JobDetailService() {
        translationService = new TranslationService();
    }

    public JobDetailService(TranslationService translationService) {
        this.translationService = translationService;
    }

    String getJobDetails(Long jobId){
        List<String> result = new ArrayList<>();
        // call to DB
        // to transaction
        result = translationService.translate(result);
        return result.get(1);
    }
}
