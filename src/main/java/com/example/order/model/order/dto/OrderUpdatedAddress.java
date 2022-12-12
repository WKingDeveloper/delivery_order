package com.example.order.model.order.dto;


import com.example.order.model.order.Address;
import lombok.Getter;

@Getter
public class OrderUpdatedAddress {

    public OrderUpdatedAddress(Long orderId, Address beforeAddress, Address afterAddress) {
        this.orderId = orderId;
        this.beforeAddress = new Address(beforeAddress);
        this.afterAddress = afterAddress;
    }

    /**
     * 주문 번호
     */
    private Long orderId;

    /**
     * 변경 전 주소
     */
    private Address beforeAddress;

    /**
     * 변경 후 주소
     */
    private Address afterAddress;

}
