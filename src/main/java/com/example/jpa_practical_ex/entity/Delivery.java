package com.example.jpa_practical_ex.entity;

import com.example.jpa_practical_ex.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "DELIVERY", schema = "jpa")
@Entity
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    //값타입으로 대체
    //private String city;
    //private String street;
    //private String zipcode;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus Status;


}
