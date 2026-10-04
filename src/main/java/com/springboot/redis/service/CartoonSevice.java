package com.springboot.redis.service;


import com.springboot.redis.entity.Cartoon;
import com.springboot.redis.entity.Product;
import com.springboot.redis.repo.CartoonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartoonSevice {

    @Autowired
    private CartoonRepository cartoonRepository;

    @Autowired
    private RedisService redisService;

    public List<Cartoon> createCartoon(List<Cartoon> cartoons) {
        return cartoonRepository.saveAll(cartoons);
    }

    public Cartoon getById(Long id) throws Exception {
        Cartoon cacheCartoon=redisService.get("cartoon::" + id,Cartoon.class);
        if (cacheCartoon != null) {
            log.info(">>>>>Fetching cartoon from cache...");
            return cacheCartoon;
        }else{
            Thread.sleep(5000);
            Cartoon cartoon= cartoonRepository.findById(id).orElseThrow(() -> new Exception("Cartoon not found with id: " + id));
            redisService.set("cartoon::" + id,cartoon,15L);
            return cartoon;
        }
    }
}
