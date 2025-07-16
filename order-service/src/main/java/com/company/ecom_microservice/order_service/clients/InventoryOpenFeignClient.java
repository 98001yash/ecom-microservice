package com.company.ecom_microservice.order_service.clients;


import com.company.ecom_microservice.order_service.dtos.OrderRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", path="/inventory")
public interface InventoryOpenFeignClient {

    @PutMapping("/products/reduce-stocks")
    Double ReduceStocks(@RequestBody OrderRequestDto orderRequestDto);
}
