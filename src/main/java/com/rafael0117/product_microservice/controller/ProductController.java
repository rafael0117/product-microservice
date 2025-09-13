package com.rafael0117.product_microservice.controller;

import com.rafael0117.product_microservice.entity.ProductEntity;
import com.rafael0117.product_microservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductRepository repository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts(){
        return repository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity product){
        repository.save(product);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editProduct(@PathVariable String id, @RequestBody ProductEntity product) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        product.setId(id);
        repository.save(product);
    }


}
