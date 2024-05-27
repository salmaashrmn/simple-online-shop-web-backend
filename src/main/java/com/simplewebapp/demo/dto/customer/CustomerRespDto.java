package com.simplewebapp.demo.dto.customer;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerRespDto {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerCode;
    private String customerPhone;
    private int isActive;
    private Date lastOrderDate;
    private String pic;
}
