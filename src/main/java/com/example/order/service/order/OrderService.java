package com.example.order.service.order;

import com.example.order.model.response.Response;
import com.example.order.repository.order.OrderRepository;
import com.example.order.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

}
