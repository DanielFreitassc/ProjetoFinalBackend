package com.unisatc.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unisatc.marketplace.dtos.ProductDTO;
import com.unisatc.marketplace.dtos.WasteResponse;
import com.unisatc.marketplace.services.ProductService;
import com.unisatc.marketplace.services.WasteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private WasteService wasteService;

    @GetMapping
    public Page<ProductDTO> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO) {
         return productService.saveProduct(productDTO);
    }

    @PutMapping("{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("{id}")
    public ProductDTO deleteProduto(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/waste")
    public WasteResponse wasteSearch() {
        return wasteService.wasteSearch();
    }
}
