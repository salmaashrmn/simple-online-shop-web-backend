package com.simplewebapp.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -13505063688481034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Long itemsId;

    @Column(name = "items_name")
    private String itemsName;

    @Column(name = "items_code")
    private String itemsCode;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private Long price;

    @Column(name = "is_available")
    private int isAvailable;

    @Column(name = "last_re_stock")
    private Date lastReStock;

    @OneToMany(mappedBy = "item")
    Set<Order> orders;
}
