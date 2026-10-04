package com.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> entityClass) throws Exception {
        Object obj= redisTemplate.opsForValue().get(key);
        if(obj==null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(obj.toString(), entityClass);
    }

    public void set(String key, Object obj, Long ttl) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue= objectMapper.writeValueAsString(obj);
        redisTemplate.opsForValue().set(key,jsonValue,ttl, TimeUnit.SECONDS);
    }

}
