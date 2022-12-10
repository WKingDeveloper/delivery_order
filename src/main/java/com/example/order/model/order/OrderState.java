package com.example.order.model.order;

public enum OrderState {

    /**
     * 결제 완료
     */
    PAID,

    /**
     * 배송 준비중
     */
    PACKING,

    /**
     * 배송중
     */
    ISSUED,

    /**
     * 배송 완료
     */
    COMPLETED,

    /**
     * 배송 문제 발생 (오배송, 누락, 파손 등)
     */
    TROUBLED,


    /**
     * 배송 취소
     */
    CANCELED,

    /**
     * 삭제
     */
    DELETED;
}
