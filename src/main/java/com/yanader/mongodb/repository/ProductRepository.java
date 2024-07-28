package com.yanader.mongodb.repository;

import com.yanader.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, Integer> {

}
