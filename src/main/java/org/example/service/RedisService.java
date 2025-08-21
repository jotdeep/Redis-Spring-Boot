package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value != null ? value.toString() : null;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
    public void setValueWithExpiry(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * NX → Set key only if it does NOT already exist
     *
     * @param key     Redis key
     * @param value   Redis value
     * @param timeout Expiration time
     * @param unit    Expiration unit
     * @return true if the key was set, false if it already exists
     */
    public boolean setIfAbsent(String key, String value, long timeout, TimeUnit unit) {
        Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
        return Boolean.TRUE.equals(result);
    }

    /**
     * XX → Set key only if it already exists
     *
     * @param key     Redis key
     * @param value   Redis value
     * @param timeout Expiration time
     * @param unit    Expiration unit
     * @return true if the key was updated, false if it did not exist
     */
    public boolean setIfPresent(String key, String value, long timeout, TimeUnit unit) {
        Boolean result = redisTemplate.opsForValue().setIfPresent(key, value, timeout, unit);
        return Boolean.TRUE.equals(result);
    }
}
