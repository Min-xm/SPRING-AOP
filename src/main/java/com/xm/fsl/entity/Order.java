package com.xm.fsl.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Order {
    private String orderNo;
    private String phone;
}
