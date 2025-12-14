package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisListService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // LPUSH key value [value ...]
    public Long lPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    // RPUSH key value [value ...]
    public Long rPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    // LPOP key
    public Object lPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    // RPOP key
    public Object rPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    // LRANGE key start stop
    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    // LLEN key
    public Long size(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
