package com.xm.fsl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test(String Test){
        log.info("在控制器中输出Test：{}",Test);
        log.info("test控制器运行");
        return "Hello Word!";
    }

}
