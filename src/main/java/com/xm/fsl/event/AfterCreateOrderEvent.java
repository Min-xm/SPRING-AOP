package com.xm.fsl.event;

import com.xm.fsl.entity.Order;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class AfterCreateOrderEvent extends ApplicationEvent {
    public AfterCreateOrderEvent(Order order) {
        super(order);
    }

    public Order getOrder(){
        return (Order) getSource();
    }


}
