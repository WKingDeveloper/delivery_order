package com.example.order.order;

import com.example.order.doc.RestDocumentation;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class OrderAssuredTest extends RestDocumentation {

    OrderFilter orderFilter;

    @BeforeEach
    void setUp() {
        orderFilter = new OrderFilter();
    }

    @Test
    @DisplayName("주문 리스트 조회 통합 테스트")
    void getOrdersAssuredTest() {
        RestAssured
                .given(this.spec)
                .baseUri("http://localhost/")
                .contentType(ContentType.JSON)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .filter(orderFilter.getOrdersSuccessFilter("주문 조회 성공"))
                .when()
                .get("/orders")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("code", Matchers.equalTo("200"));
    }

    @Test
    @DisplayName("주문 주소 변경 성공 통합 테스트")
    void updateOrderAddressAssuredTest() {
        RestAssured
                .given(this.spec)
                .baseUri("http://localhost/")
                .contentType(ContentType.JSON)
                .queryParam("id", "2")
                .queryParam("baseAddress", "서울특별시 종로구 청와대로 1")
                .queryParam("detailAddress", "1층")
                .filter(orderFilter.updateOrderAddressSuccessFilter("주문 주소 변경 성공"))
                .when()
                .get("/orders/update/address")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("code", Matchers.equalTo("200"))
                .body("data.afterAddress.baseAddress", Matchers.equalTo("서울특별시 종로구 청와대로 1"))
                .body("data.afterAddress.detailAddress", Matchers.equalTo("1층"))
        ;
    }

}

