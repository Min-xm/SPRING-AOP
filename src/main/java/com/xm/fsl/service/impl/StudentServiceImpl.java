package com.xm.fsl.service.impl;

import com.xm.fsl.entity.Student;
import com.xm.fsl.event.StudentEvent;
import com.xm.fsl.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void addStudent(Student student) {
        log.info("------------------------分割线-----------------------------");
        log.info("事件已发布，等待被监听");
        //发布事件
        applicationEventPublisher.publishEvent(new StudentEvent(student));
    }




    @EventListener
    public void studentListener(StudentEvent event) throws InterruptedException{
        Student student = event.getStudent();
        //等待2秒模拟监听过程
        Thread.sleep(2000);
        log.info("事件已被监听: "+event.getClass().getName());
        log.info("添加新学生：{}",student.toString());
    }



}
