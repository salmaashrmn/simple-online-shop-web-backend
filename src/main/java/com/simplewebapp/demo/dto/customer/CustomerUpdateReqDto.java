package com.simplewebapp.demo.dto.customer;

import lombok.Data;

@Data
public class CustomerUpdateReqDto {
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerCode;
    private String customerPhone;
    private String pic;
}
