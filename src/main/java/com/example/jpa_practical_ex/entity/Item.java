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
    private long id;
    private String name;
    private long price;
    private int stockQuantity;
}
