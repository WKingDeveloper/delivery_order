package com.example.order.controller.order;

import com.example.order.model.response.ResponseDto;
import com.example.order.model.response.SuccessResponseDto;
import com.example.order.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto readOrders(
            @RequestParam(value = "page", defaultValue = "0") Integer pageParam,
            @RequestParam(value = "size", defaultValue = "50") Integer sizeParam) {
        log.debug("OrderController -> readChangedProducts()");
        return orderService.getOrders(pageParam,sizeParam);
    }

    @RequestMapping(value = "/orders/update/address", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto modifyOrderAddress(
            @RequestParam(value = "id") Long orderId,
            @RequestParam(value = "baseAddress") String baseAddressParam,
            @RequestParam(value = "detailAddress") String detailAddressParam) {
        log.debug("OrderController -> readChangedProducts()");
        return orderService.updateOrderAddress(orderId, baseAddressParam, detailAddressParam);
    }

}
