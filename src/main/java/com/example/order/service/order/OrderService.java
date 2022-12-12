package com.example.order.service.order;

import com.example.order.model.order.Address;
import com.example.order.model.order.Order;
import com.example.order.model.order.dto.OrderUpdatedAddress;
import com.example.order.model.response.Response;
import com.example.order.repository.order.OrderRepository;
import com.example.order.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public Response getOrders(Integer pageNumber, Integer pageSize) {
        log.debug("OrderService -> getOrders()");
        Response response = new Response();
        response.setData(orderRepository.findOrdersByDate(DateUtils.getThreeDaysAgo(), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"))));
        response.setCode("200");
        return response;
    }

    public Response updateOrderAddress(Long orderId, String baseAddress, String detailAddress) {
        log.debug("OrderService -> updateOrderAddress()");
        Response response = new Response();
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if(!optionalOrder.isPresent()) {
            response.setCode("400");
            response.setError("존재하지 않는 주문 ID 입니다.");
            return response;
        }

        Order order = optionalOrder.get();
        if(!order.isEditAble() || order.isIssued()){
            response.setCode("400");
            response.setError("주소를 수정할 수 없는 상품입니다.");
            return response;
        }

        Address newAddress =  new Address(baseAddress, detailAddress);
        OrderUpdatedAddress orderUpdatedAddress = new OrderUpdatedAddress(
            orderId, order.getAddress(), newAddress
        );

        order.setAddress(newAddress);


        response.setCode("200");
        response.setData(orderUpdatedAddress);
        return response;
    }

}
