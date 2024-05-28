package com.simplewebapp.demo.dto.order;

import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.entity.Item;
import lombok.Data;

import java.util.Date;

@Data
public class OrderReqDto {
    private String orderCode;
    private int quantity;
    private Long customerId;
    private Long itemId;
}
