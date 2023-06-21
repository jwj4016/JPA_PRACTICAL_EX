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
    private Long id;

    //데이터 중심의 설계.
    //private long orderId;
    //주문 상품에서 상품을 참조할 일은 많지만, 상품에서 주문상품을 참조할 일은 거의 없기 때문에, 주문 상품과 상품은 다대일 단방향.
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;          //주문 상품

    //데이터 중심의 설계.
    //private long itemId;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")  //외래키가 있는 OrderItem이 연관관계의 주인.
    private Order order;        //주문

    private long orderPrice;    //주문 가격

    private int count;          //주문 수량


}
