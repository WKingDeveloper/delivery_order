package com.example.order.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    public Address(Address address) {
        this.baseAddress = address.getBaseAddress();
        this.detailAddress = address.getDetailAddress();
    }

    /**
     * 기본 주소
     */
    @Column(name = "address_1")
    private String baseAddress="";

    /**
     * 상세 주소
     */
    @Column(name = "address_2")
    private String detailAddress="";

}
