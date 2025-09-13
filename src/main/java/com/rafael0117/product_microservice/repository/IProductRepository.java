package com.rafael0117.product_microservice.repository;

import com.rafael0117.product_microservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<ProductEntity,String> {
}
