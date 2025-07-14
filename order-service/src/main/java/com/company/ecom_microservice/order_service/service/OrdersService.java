package com.company.ecom_microservice.order_service.service;


import com.company.ecom_microservice.order_service.dtos.OrderRequestDto;
import com.company.ecom_microservice.order_service.entity.Orders;
import com.company.ecom_microservice.order_service.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final ModelMapper modelMapper;
    private final OrdersRepository ordersRepository;
    public List<OrderRequestDto> getAllOrders(){
        log.info("Fetching all Orders");
        List<Orders> orders = ordersRepository.findAll();
        return orders.stream().map(order->modelMapper.map(order, OrderRequestDto.class)).toList();
    }

    public OrderRequestDto getOrderById(Long id){
        log.info("Fetching order with ID: {}",id);
        Orders order = ordersRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        return modelMapper.map(order,OrderRequestDto.class);
    }
}
