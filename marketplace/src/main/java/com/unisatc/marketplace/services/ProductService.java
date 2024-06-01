package com.unisatc.marketplace.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unisatc.marketplace.dtos.ProductDTO;
import com.unisatc.marketplace.mapper.ProductMapper;
import com.unisatc.marketplace.models.ProductEntity;
import com.unisatc.marketplace.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    
    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        ProductEntity product = productRepository.save(productEntity);
        return productMapper.toDto(product);
    }

    public Page<ProductDTO> getProducts(Pageable pageable) {
        Page<ProductEntity> products = productRepository.findAllProducts(pageable);
        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto cadastrado no momento");
        }
        return products.map(productMapper::toDto);
    }
   
    public ProductDTO getProduct(Long id) {
        Optional<ProductEntity> productOpt = productRepository.findById(id);
        if(productOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto com este ID");
        return productMapper.toDto(productOpt.get());
    }

   public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<ProductEntity> productOpt = productRepository.findById(id);
        if(productOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto com este ID");
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        productEntity.setId(id);
        ProductEntity updatedProduct = productRepository.save(productEntity);
        return productMapper.toDto(updatedProduct);
    }

    public ProductDTO deleteProduct(Long id) {
        Optional<ProductEntity> productOpt = productRepository.findById(id);
        if(productOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto com este ID");
        productRepository.delete(productOpt.get());
        return productMapper.toDto(productOpt.get());
    }
    
}
