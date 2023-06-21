package com.example.jpa_practical_ex.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER", schema = "jpa")
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //id가 null 일 경우 처리를 위해 long -> Long으로 변경.
    //private long id;
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
