package com.simplewebapp.demo.dto.customer;

import lombok.Data;

@Data
public class CustomerReqDto {
    private String customerName;
    private String customerAddress;
    private String customerCode;
    private String customerPhone;
    private String pic;
}
