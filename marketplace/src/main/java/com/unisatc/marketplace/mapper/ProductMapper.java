package com.unisatc.marketplace.mapper;

import org.springframework.stereotype.Component;

import com.unisatc.marketplace.dtos.ProductDTO;
import com.unisatc.marketplace.models.ProductEntity;

@Component
public class ProductMapper {
    public ProductDTO toDto(ProductEntity productEntity) {
        return new ProductDTO(
            productEntity.getId(),
            productEntity.getName(),
            productEntity.getPrice(),
            productEntity.getDescription(),
            productEntity.getValidity(),
            productEntity.getImage()
        ); 
    }

    public ProductEntity toEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
        .name(productDTO.name())
        .price(productDTO.price())
        .description(productDTO.description())
        .validity(productDTO.validity())
        .image(productDTO.image())
        .build();
    }
}
