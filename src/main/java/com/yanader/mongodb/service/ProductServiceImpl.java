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
    private ProductRepository productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product deleteProduct(int id) {
        Optional<Product> p = productRepo.findById(id);
        productRepo.deleteById(id);
        return p.orElse(null);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate =  productRepo.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());
        productRepo.save(productToUpdate);
        return productToUpdate;

    }
}
