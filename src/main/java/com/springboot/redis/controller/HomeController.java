package com.springboot.redis.controller;

import com.springboot.redis.entity.Product;
import com.springboot.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Product API!";
    }

    @GetMapping("/get")
    public List<Product> getProducts() throws Exception {
        return productService.getProducts();
    }

    @GetMapping("/getById/{id}")
    public Product getProductById(@PathVariable Long id) throws Exception {
        return productService.getById(id);
    }


    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody List<Product> product) {
        return productService.createProduct(product);
    }

    @PostMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
