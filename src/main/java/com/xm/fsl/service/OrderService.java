package com.xm.fsl.service;

import com.xm.fsl.entity.Order;
import com.xm.fsl.event.AfterCreateOrderEvent;

public interface OrderService {
    /**
     * 简单的创建订单方法
     */
    void createOrder(Order order);

    // TODO 2. 事件监听处理，加入@EventListener注解后，该方法可以看出一个事件监听者
    void afterCreateOrder(AfterCreateOrderEvent afterCreateOrderEvent) throws InterruptedException;

}
