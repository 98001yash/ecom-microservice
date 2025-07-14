package com.company.ecom_microservice.order_service.repository;

import com.company.ecom_microservice.order_service.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
