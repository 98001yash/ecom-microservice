package com.company.ecom_microservice.inventory_service.service;


import com.company.ecom_microservice.inventory_service.dtos.ProductDto;
import com.company.ecom_microservice.inventory_service.entity.Product;
import com.company.ecom_microservice.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<ProductDto> getAllInventory(){
        log.info("Fetching all inventory items..");
        List<Product> inventories = productRepository.findAll();
        return inventories.stream()
                .map(product->modelMapper.map(product,ProductDto.class))
                .toList();
    }

    public ProductDto getProductById(Long id){
        log.info("Fetching Product with id: {}",id);
        Optional<Product> inventory = productRepository.findById(id);
        return inventory.map(item->modelMapper.map(item,ProductDto.class))
                .orElseThrow(()->new RuntimeException("Inventory not found"));
    }
}
