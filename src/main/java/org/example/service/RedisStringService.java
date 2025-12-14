package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisStringService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // SET key value
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // SET key value EX timeout
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    // SETNX key value
    public Boolean setIfAbsent(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    // SET key value EX timeout NX
    public Boolean setIfAbsent(String key, Object value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
    }

    // SET key value XX
    public Boolean setIfPresent(String key, Object value) {
        return redisTemplate.opsForValue().setIfPresent(key, value);
    }

    // SET key value EX timeout XX
    public Boolean setIfPresent(String key, Object value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfPresent(key, value, timeout, unit);
    }

    // GET key
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // GETSET key value (Deprecated in Redis 6.2, use SET key value GET)
    public Object getAndSet(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    // MGET key [key ...]
    public List<Object> multiGet(List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    // MSET key value [key value ...]
    public void multiSet(Map<String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    // MSETNX key value [key value ...]
    public Boolean multiSetIfAbsent(Map<String, Object> map) {
        return redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    // INCR key
    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    // INCRBY key increment
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    // INCRBYFLOAT key increment
    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    // DECR key
    public Long decrement(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    // DECRBY key decrement
    public Long decrement(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    // APPEND key value
    public Integer append(String key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    // GETRANGE key start end
    public String get(String key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    // STRLEN key
    public Long size(String key) {
        return redisTemplate.opsForValue().size(key);
    }
}
