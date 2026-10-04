package com.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

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

    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody List<Product> product) {
        return productService.createProduct(product);
    }
}
