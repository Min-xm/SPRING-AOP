package com.xm.fsl.service.impl;

import com.xm.fsl.entity.Order;
import com.xm.fsl.event.AfterCreateOrderEvent;
import com.xm.fsl.service.OrderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void createOrder(Order order) {
        System.out.println("创建订单 order:" + order.getOrderNo() + " 结束");
        // TODO 1. 调用事件发布者发布事件,解耦
        applicationEventPublisher.publishEvent(new AfterCreateOrderEvent(order));
        System.out.println("createOrder方法 结束");
    }

    @Override
    @EventListener
    // TODO 2. 事件监听处理，加入@EventListener注解后，该方法可以看出一个事件监听者
    public void afterCreateOrder(AfterCreateOrderEvent afterCreateOrderEvent) throws InterruptedException {
        Order order = afterCreateOrderEvent.getOrder();
        Thread.sleep(2000);
        System.out.println("调用短信通知服务：" + order.getPhone());
        System.out.println("调用积分服务增加贷款积分:" + order.getOrderNo());
    }

}
