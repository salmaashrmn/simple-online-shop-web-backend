package com.simplewebapp.demo.dto.item;

import lombok.Data;

import java.util.Date;

@Data
public class ItemUpdateReqDto {
    private Long itemsId;
    private String itemsName;
    private String itemsCode;
    private int stock;
    private Long price;
}
