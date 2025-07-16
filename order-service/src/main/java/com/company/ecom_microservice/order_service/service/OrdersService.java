package com.company.ecom_microservice.order_service.service;


import com.company.ecom_microservice.order_service.clients.InventoryOpenFeignClient;
import com.company.ecom_microservice.order_service.dtos.OrderRequestDto;
import com.company.ecom_microservice.order_service.entity.OrderItem;
import com.company.ecom_microservice.order_service.entity.Orders;
import com.company.ecom_microservice.order_service.enums.OrderStatus;
import com.company.ecom_microservice.order_service.repository.OrdersRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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
    private final InventoryOpenFeignClient inventoryOpenFeignClient;


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

  //  @Retry(name = "inventoryRetry", fallbackMethod = "createOrderFallback")
    @CircuitBreaker(name = "inventoryCircuitBreaker", fallbackMethod = "createOrderFallback")
    @RateLimiter(name = "inventoryRateLimiter", fallbackMethod = "createOrderFallback")
    public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {
        log.info("calling the create-order method");
       Double totalPrice = inventoryOpenFeignClient.ReduceStocks(orderRequestDto);

       Orders orders = modelMapper.map(orderRequestDto, Orders.class);
       for(OrderItem orderItem: orders.getItems()){
           orderItem.setOrder(orders);
       }

       orders.setTotalPrice(totalPrice);
       orders.setOrderStatus(OrderStatus.CONFIRMED);


       Orders savedOrder = ordersRepository.save(orders);

       return modelMapper.map(savedOrder, OrderRequestDto.class);
    }

    public OrderRequestDto createOrderFallback(OrderRequestDto orderRequestDto, Throwable throwable){
        log.error("Fallback occured due to: {}",throwable.getMessage());
        return new OrderRequestDto();
    }
}
