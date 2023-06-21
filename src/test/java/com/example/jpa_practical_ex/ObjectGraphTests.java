package com.example.jpa_practical_ex;

import com.example.jpa_practical_ex.entity.Item;
import com.example.jpa_practical_ex.entity.Member;
import com.example.jpa_practical_ex.entity.Order;
import com.example.jpa_practical_ex.entity.OrderItem;
import com.example.jpa_practical_ex.enums.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ObjectGraphTests {
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Test
    void 객체_그래프_탐색1() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Member newMember = new Member();
        newMember.setName("정우재");
        newMember.setCity("서울");
        newMember.setStreet("영등포");
        newMember.setZipcode("123");

        entityManager.persist(newMember);

        Order newOrder = new Order();
        newOrder.setMember(newMember);
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setStatus(OrderStatus.ORDER);


        Item item1 = entityManager.find(Item.class, 1);
        Item item2 = entityManager.find(Item.class, 2);
        Item item3 = entityManager.find(Item.class, 3);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setOrder(newOrder);
        orderItem1.setItem(item1);
        orderItem1.setOrderPrice(item1.getPrice());
        orderItem1.setCount(1);
        newOrder.addOrderItem(orderItem1);



        OrderItem orderItem2 = new OrderItem();
        orderItem2.setOrder(newOrder);
        orderItem2.setItem(item2);
        orderItem2.setOrderPrice(item2.getPrice());
        orderItem2.setCount(1);
        newOrder.addOrderItem(orderItem2);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setOrder(newOrder);
        orderItem3.setItem(item3);
        orderItem3.setOrderPrice(item3.getPrice());
        orderItem3.setCount(1);
        newOrder.addOrderItem(orderItem3);

        entityManager.persist(orderItem1);
        entityManager.persist(orderItem2);
        entityManager.persist(orderItem3);

        entityManager.persist(newOrder);
        tx.commit();
    }

    @Test
    void 테스트틀_위한_상품_데이터생성() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Item apple = new Item();
        apple.setName("apple");
        apple.setPrice(1000);
        apple.setStockQuantity(500);

        Item chocolate = new Item();
        chocolate.setName("chocolate");
        chocolate.setPrice(2000);
        chocolate.setStockQuantity(100);

        Item ipad = new Item();
        ipad.setName("ipad");
        ipad.setPrice(1000000);
        ipad.setStockQuantity(50);

        entityManager.persist(apple);
        entityManager.persist(ipad);
        entityManager.persist(chocolate);


        tx.commit();
    }

    @Test
    void 객체_그래프_탐색2() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        Order order = entityManager.find(Order.class, 52);
        Member member = order.getMember();  //주문한 회원, 참조 사용
        OrderItem orderItem = order.getOrderItems().get(0);
        Item item = orderItem.getItem();

    }

}
