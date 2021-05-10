package com.xm.fsl.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
@Slf4j
public class TestAspectJ {

    @Pointcut("execution(boolean com.xm.fsl.service.impl.TestService.insert(*,String)) && args(params,id) && bean(testService)")
    public void point(Map<String, Object> params,String id){}


    @Before("point(params,id)")
    public void Before(Map<String, Object> params,String id){
        System.out.println("aop-----调用前执行");
    }

    @Around("point(params,id)")
    public boolean around(ProceedingJoinPoint pj,Map<String, Object> params,String id) throws Throwable {
        if (id.equals("1")){
            log.info("id为1调用AOP around封装的方法");
            //如果不调用该对象的 proceed() 方法，表示原目标方法被阻塞调用
            pj.proceed();
        }
        log.info("环绕通知替换方法");
        log.info("环绕通知中获取原目标方法的参数id: "+id);
        return false;
    }


}
