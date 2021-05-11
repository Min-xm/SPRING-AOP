package com.xm.fsl.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
@Aspect
public class TestAspect {

    @Pointcut("execution(* com.xm.fsl.controller.TestController.test(..))")
    public void point(){}

    @Around("point()")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("切片开始。。。");
        long startTime = System.currentTimeMillis();

        // 获取请求入参
        Object[] args = proceedingJoinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> log.info("arg is {}", arg));

        // 获取相应
//        Object response = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        log.info("请求:{}, 耗时{}ms", proceedingJoinPoint.getSignature(), (endTime - startTime));
        log.info("切片结束。。。");

        return proceedingJoinPoint.proceed();
    }

}
