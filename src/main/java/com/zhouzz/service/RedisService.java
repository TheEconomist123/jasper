package com.zhouzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 增/改
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 删
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

    // 查
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    // 设置过期时间
    public void setValueWithExpire(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);

    }

}
