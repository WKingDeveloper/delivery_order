package com.example.order.repository.order;

import com.example.order.model.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o WHERE o.createdAt >= :createdAt")
    Page<Order> findOrdersByDate(@Param("createdAt") Timestamp createdAt, Pageable pageable);
}
