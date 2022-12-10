package com.example.order.model.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    /**
     * 기본 주소
     */
    @Column(name = "address_1")
    private String baseAddress;

    /**
     * 상세 주소
     */
    @Column(name = "address_2")
    private String detailedAddress;

}
