package com.example.jpa_practical_ex.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "jpa", name = "ITEM")
@Setter
@Getter
public class Item {
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;            //이름
    private long price;             //가격
    private int stockQuantity;      //재고수량
}
