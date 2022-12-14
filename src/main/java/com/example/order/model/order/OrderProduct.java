package com.example.order.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "OrderProduct")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 상품 명
     */
    private String name;

    /**
     * 수량
   리 */
    private Integer quantity;

    /**
     * 주문 번호
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    /**
     * 생성 시간
     */
    @JsonIgnore
    @Column(insertable = false,updatable = false)
    private Timestamp createdAt;

    /**
     * 수정 시간
     */
    @JsonIgnore
    @Column(insertable = false,updatable = false)
    private Timestamp updatedAt;

}
