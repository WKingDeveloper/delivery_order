package com.example.order.model.order;

import com.example.order.model.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 주소
     */
    @Embedded
    private Address address;

    /**
     * 결제 종류
     */
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    /**
     * 주문 접수 플랫폼
     */
    @Enumerated(EnumType.STRING)
    private Platform platform;

    /**
     * 요청 사항
     */
    private String request;

    /**
     * 금액
     */
    private BigDecimal price;

    /**
     * 주문 상태
     */
    @Enumerated(EnumType.STRING)
    private OrderState status;

    /**
     * 배차 완료 여부
     */
    @Column(name = "issued")
    private boolean isIssued;

    /**
     * 고객 전화 번호
     */
    private String phoneNumber;

    /**
     * 주문 상품
     */
//    @OneToMany
//    private List<Product> product;

    /**
     * 생성 시간
     */
    @Column(insertable = false,updatable = false)
    private Timestamp createdAt;

    /**
     * 수정 시간
     */
    @Column(insertable = false,updatable = false)
    private Timestamp updatedAt;

}
