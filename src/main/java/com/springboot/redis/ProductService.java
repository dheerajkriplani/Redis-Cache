package com.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts()  throws Exception {
        Thread.sleep(5000);
        return productRepository.findAll();
    }
    public List<Product> createProduct(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
