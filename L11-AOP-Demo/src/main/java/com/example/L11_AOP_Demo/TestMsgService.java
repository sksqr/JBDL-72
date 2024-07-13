
package com.example.L11_AOP_Demo;

import com.example.L11_AOP_Demo.aspect.LogExecutionTime;
import com.example.L11_AOP_Demo.aspect.SimpleAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestMsgService {

    private Logger LOGGER = LoggerFactory.getLogger(TestMsgService.class);

    @LogExecutionTime
    public String getTestMsg(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Executing getTestMsg");
        return "Test Hello from :"+Thread.currentThread().getName();
    }
}
