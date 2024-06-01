package com.unisatc.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisatc.marketplace.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    
}
