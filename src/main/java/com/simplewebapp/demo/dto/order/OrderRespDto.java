package com.simplewebapp.demo.dto.order;

import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.entity.Item;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.Date;

@Data
public class OrderRespDto {
    private Long orderId;
    private String orderCode;
    private Date orderDate;
    private Long totalPrice;
    private int quantity;
    Customer customer;
    Item item;
}
