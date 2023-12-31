package com.example.jpa_practical_ex.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    private Date createDate;        //등록일
    private Date lastModifiedDate;  //수정일
}
