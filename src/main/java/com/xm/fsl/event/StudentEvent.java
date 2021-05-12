package com.xm.fsl.event;

import com.xm.fsl.entity.Student;
import org.springframework.context.ApplicationEvent;


public class StudentEvent extends ApplicationEvent {

    public StudentEvent(Object source) {
        super(source);
    }

    public Student getStudent(){

        return (Student) getSource();
    }



}
