package com.springboot.redis.controller;


import com.springboot.redis.entity.Cartoon;
import com.springboot.redis.entity.Product;
import com.springboot.redis.service.CartoonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoon")
public class CartoonController {

    @Autowired
    private CartoonSevice cartoonService;

    @GetMapping("/get/{id}")
    public Cartoon getCartoonById(@PathVariable Long id) throws Exception {
        return cartoonService.getById(id);
    }
    @PostMapping("/create")
    public List<Cartoon> createCartoon(@RequestBody List<Cartoon> cartoon) {
        return cartoonService.createCartoon(cartoon);
    }
}
