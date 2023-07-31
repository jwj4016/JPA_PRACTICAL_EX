package com.example.jpa_practical_ex.entity;

import com.example.jpa_practical_ex.entity.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "CATEGORY", schema = "jpa")
@Entity
public class Category extends BaseEntity{
    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM"
        , joinColumns = @JoinColumn(name = "CATEGORY_ID")
        , inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //연관관계 메소드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
