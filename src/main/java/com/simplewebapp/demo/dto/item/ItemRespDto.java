package com.simplewebapp.demo.dto.item;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class ItemRespDto {
    private Long itemsId;
    private String itemsName;
    private String itemsCode;
    private int stock;
    private Long price;
    private int isAvailable;
    private Date lastReStock;
}
