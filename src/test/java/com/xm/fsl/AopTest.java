package com.xm.fsl;


import com.xm.fsl.entity.Order;
import com.xm.fsl.entity.Student;
import com.xm.fsl.service.ILogService;
import com.xm.fsl.service.OrderService;
import com.xm.fsl.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AopTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Resource
    private ILogService service;

    @Resource
    private OrderService orderService;
    @Resource
    private StudentService studentService;


    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @Test
    public void context() throws Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/test")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("嘟嘟MD独立博客"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot干货系列"))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();


        System.out.println("我先修改dev");
        service.insert(new HashMap<>(),"1");

        Order order = new Order();
        order.setOrderNo("N123124124124");
        order.setPhone("18782202534");
        orderService.createOrder(order);

        Student student = new Student();
        log.info(""+student.hashCode());
        log.info(student.getName()+student.getSex());
        student.setName("天小明");
        student.setSex("男");
        studentService.addStudent(student);




    }

}