package com.company.ecom_microservice.inventory_service.dtos;


import lombok.Data;

@Data
public class OrderRequestItemDto {


    private Long productId;
    private Integer quantity;
}
