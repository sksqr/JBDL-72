package com.example.L11_AOP_Demo.aspect;

import com.example.L11_AOP_Demo.AOPController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SimpleAspect {

    private Logger LOGGER = LoggerFactory.getLogger(SimpleAspect.class);

    @Before("execution(* com.example.L11_AOP_Demo.TestMsgService.getTestMsg(..))")
    public void beforeMethod(){
        LOGGER.info("Executing code before actual method");
    }


//    @Before("@annotation(com.example.L11_AOP_Demo.aspect.LogExecutionTime)")
//    public void beforeAnnotatedMethod(){
//        LOGGER.info("Executing code before Annotated method");
//    }

    @Around("@annotation(com.example.L11_AOP_Demo.aspect.LogExecutionTime)")
    public Object logExecutionTimeOfTheMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Executing {} Time: {}",proceedingJoinPoint.getTarget(), end-start);
        return result;
    }


    @After("execution(* com.example.L11_AOP_Demo.TestMsgService.getTestMsg(..))")
    public void afterMethod(){
        LOGGER.info("Executing code after actual method");
    }

}
