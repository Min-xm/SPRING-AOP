package com.xm.fsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(AopMain8080.class,args);
    }
}
