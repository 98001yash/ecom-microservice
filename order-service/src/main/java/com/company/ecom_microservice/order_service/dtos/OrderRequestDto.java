package com.company.ecom_microservice.order_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {

    private Long id;
    private List<OrderRequestIemDto> items;
    private BigDecimal totalPrice;
}
