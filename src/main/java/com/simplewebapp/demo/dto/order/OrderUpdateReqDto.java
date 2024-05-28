package com.simplewebapp.demo.dto.order;

import lombok.Data;

@Data
public class OrderUpdateReqDto {
    private Long orderId;
    private String orderCode;
    private int quantity;
    private Long customerId;
    private Long itemId;
}
