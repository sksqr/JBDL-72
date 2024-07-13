package com.example.L11_AOP_Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AOPController {

    private Logger LOGGER = LoggerFactory.getLogger(AOPController.class);

    @Autowired
    private AOPService aopService;

    @Autowired
    private TestMsgService testMsgService;

//    @GetMapping("/hello")
//    public String getHello()
//    {
//        Long startTime = System.currentTimeMillis();
//        String msg= aopService.getMsg();
//        Long endTime = System.currentTimeMillis();
//        LOGGER.info("Total Time Taken: {}",endTime-startTime);
//        return msg;
//    }


    @GetMapping("/hello")
    public String getHello()
    {
        return aopService.getMsg();
    }


//    @GetMapping("/test")
//    public String getTestHello()
//    {
//        Long startTime = System.currentTimeMillis();
//        String msg= testMsgService.getTestMsg();
//        Long endTime = System.currentTimeMillis();
//
//      //  msg = msg + aopService.getMsg();
//
//        LOGGER.info("Total Time Taken: {}",endTime-startTime);
//        return msg;
//    }


        @GetMapping("/test")
    public String getTestHello()
    {

        return testMsgService.getTestMsg();
    }




}
