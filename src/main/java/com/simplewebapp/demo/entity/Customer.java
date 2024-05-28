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
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = -13505063688481034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "last_order_date")
    private Date lastOrderDate;

    @Column(name = "pic")
    private String pic;

    @OneToMany(mappedBy = "customer")
    Set<Order> orders;
}
