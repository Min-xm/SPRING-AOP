package com.xm.fsl;


import com.xm.fsl.entity.Student;
import com.xm.fsl.service.ILogService;
import com.xm.fsl.service.impl.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AopTest {

    @Resource
    private ILogService service;

    @Test
    public void context(){
        System.out.println("推送dev分支");
        service.insert(new HashMap<>(),"1");
    }

}
