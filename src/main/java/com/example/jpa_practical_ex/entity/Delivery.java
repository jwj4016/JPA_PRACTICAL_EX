package com.example.jpa_practical_ex.entity;

import com.example.jpa_practical_ex.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "DELIVERY", schema = "jpa")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus Status;


}
