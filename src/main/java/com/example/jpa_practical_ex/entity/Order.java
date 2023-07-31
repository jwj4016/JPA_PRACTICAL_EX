package com.example.jpa_practical_ex.entity;

import com.example.jpa_practical_ex.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "jpa", name = "ORDERS")
@Getter
@Setter
public class Order extends BaseEntity{
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //데이터 중심의 설계. 테이블의 외래키를 객체에 그대로 가져와서 사용할 경우 문제가 된다. 객체 그래프 탐색이 불가능하다.
    //객체는 참조를 사용해 연관된 객체를 찾고, 테이블은 외래키를 사용해 연관 테이블을 찾는다.
    //객체가 다른 객체를 참조하지도 않는다.
    //객체는 외래키 대신 참조를 이용해야 한다.
    //private long memberId;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")     //외래키(MEMBER_ID)가 있는 Order가 연관관계 주인.
    private Member member;              //주문 회원

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;    //주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;         //주문 상태

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;



    public void setMember(Member member) {
        //기존관계 제거
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);

    }


}
