package com.example.springbootaoplog.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * LogAspect
 *
 * @Description
 * @Author QianYiyu
 */
@Component
@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.example.springbootaoplog.service.TestService.method1())")
    public void pointCut() {}

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("Around Before " + methodName);
        try {
            logger.info(methodName + " is running");
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("Around After " + methodName);
    }

    @Before("execution(* com.example.springbootaoplog.service.TestService.method2())")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before " + methodName);
    }

    @After("execution(* com.example.springbootaoplog.service.TestService.method2())")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After " + methodName);
    }

    @AfterThrowing("execution(* com.example.springbootaoplog.service.TestService.method3())")
    public void afterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Throwing Exception By " + methodName);
    }
}
