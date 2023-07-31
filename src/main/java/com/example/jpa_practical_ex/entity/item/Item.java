package com.example.jpa_practical_ex.entity.item;

import com.example.jpa_practical_ex.entity.BaseEntity;
import com.example.jpa_practical_ex.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(schema = "jpa", name = "ITEM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Setter
@Getter
public abstract class Item extends BaseEntity {
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;            //이름
    private long price;             //가격
    private int stockQuantity;      //재고수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
