package com.example.L16_minor_project_2.util;

import com.example.L16_minor_project_2.entity.Visit;
import com.example.L16_minor_project_2.enums.VisitStatus;
import com.example.L16_minor_project_2.repo.VisitRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
public class VisitExpireScheduledTask {
    private Logger LOGGER = LoggerFactory.getLogger(VisitExpireScheduledTask.class);

    @Autowired
    private VisitRepo visitRepo;

    @Scheduled(fixedDelay = 50000)
    public void markVisitAsExpired(){
        LOGGER.info("Marking visit as Expired");

        Date date = new Date();
        date.setMinutes(date.getMinutes()-30);

        List<Visit> visitList = visitRepo.findByStatusAndCreatedDateLessThanEqual(VisitStatus.WAITING,date);
        for(Visit visit:visitList){
            visit.setStatus(VisitStatus.EXPIRE);
        }
        visitRepo.saveAll(visitList);

    }
}
