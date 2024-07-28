package com.yanader.mongodb.service;

import com.yanader.mongodb.model.Product;
import com.yanader.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(int id) {
        Optional<Product> p = productRepository.findById(id);
        productRepository.deleteById(id);
        return p.orElse(null);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate =  productRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());
        productRepository.save(productToUpdate);
        return productToUpdate;

    }
}
