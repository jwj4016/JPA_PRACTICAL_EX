package com.example.jpa_practical_ex.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
