package com.example.jpa_practical_ex.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER_ITEM", schema = "jpa")
@Getter
@Setter
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //데이터 중심의 설계.
    private long orderId;

    //데이터 중심의 설계.
    private long itemId;

    private long orderPrice;

    private int count;


}
