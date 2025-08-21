package org.example.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisDeleteService {

    private final StringRedisTemplate redisTemplate;

    public RedisDeleteService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // DEL single key
    public boolean deleteKey(String key) {
        Boolean result = redisTemplate.delete(key);
        return Boolean.TRUE.equals(result);
    }

    // DEL multiple keys
    public long deleteKeys(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    // EXPIRE
    public boolean expireKey(String key, long timeout, TimeUnit unit) {
        Boolean result = redisTemplate.expire(key, timeout, unit);
        return Boolean.TRUE.equals(result);
    }

    // PERSIST
    public boolean persistKey(String key) {
        Boolean result = redisTemplate.persist(key);
        return Boolean.TRUE.equals(result);
    }
}
