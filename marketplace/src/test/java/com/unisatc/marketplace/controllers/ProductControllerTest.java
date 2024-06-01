package com.unisatc.marketplace.controllers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.unisatc.marketplace.dtos.ProductDTO;
import com.unisatc.marketplace.models.ProductEntity;
import com.unisatc.marketplace.repositories.ProductRepository;
import com.unisatc.marketplace.services.ProductService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("Retorna 100 elementos")
    public void getProducts() {
        for (int i = 0; i < 100; i++) {
            createTestProduct();
        }

        Pageable pageable = PageRequest.of(0, 10);

        List<ProductDTO> productDTOs = productService.getProducts(pageable).getContent();

        assertThat(productDTOs).hasSize(10); 
        assertThat(productDTOs.get(0).id()).isNotNull();
    }

    private void createTestProduct() {
        ProductEntity productTest = new ProductEntity();
        productRepository.save(productTest);
    }
}
