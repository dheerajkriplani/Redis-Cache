package com.springboot.redis.service;

import com.springboot.redis.entity.Product;
import com.springboot.redis.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Cacheable(value = "products", key = "'allProducts'")//to cache the list of products with a specific key
    public List<Product> getProducts()  throws Exception {
        Thread.sleep(5000);
        log.info(">>>>>Fetching products from database...");
        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")//to cache the product with the given id
    public Product getById(Long id)  throws Exception {
        Thread.sleep(5000);
        log.info(">>>>>Fetching products from database...");
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> createProduct(List<Product> products) {
        return productRepository.saveAll(products);
    }


    @CachePut(value = "products", key = "#id")//to update the cache with the new product data after updating it in the database
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }


    @Caching(evict = {@CacheEvict(value = "products", key = "#id"), @CacheEvict(value = "products", key = "'allProducts'")})//to delete the cache entry for the product with the given id after deleting it from the database
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
}
