package org.gfg.didemo;

import java.util.List;

public class DiDemo {

    public static void main(String[] args) {

//        JobListingService jobListingService = new JobListingService();
//        List<String> jobs = jobListingService.getAllJobsByKeyword("java");
//
//        JobDetailService jobDetailService = new JobDetailService();
//        String jobDetails = jobDetailService.getJobDetails(134l);

        TranslationService translationService = new TranslationService();

        JobListingService jobListingService = new JobListingService(translationService);
        List<String> jobs = jobListingService.getAllJobsByKeyword("java");

        JobDetailService jobDetailService = new JobDetailService(translationService);
        String jobDetails = jobDetailService.getJobDetails(134l);





    }
}
