package com.company.ecom_microservice.order_service.dtos;


import lombok.Data;

@Data
public class OrderRequestIemDto {

    private Long id;
    private Long productId;
    private Integer quantity;
}
