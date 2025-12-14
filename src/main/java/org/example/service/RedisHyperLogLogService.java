package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisHyperLogLogService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // PFADD key element [element ...]
    public Long add(String key, Object... values) {
        return redisTemplate.opsForHyperLogLog().add(key, values);
    }

    // PFCOUNT key [key ...]
    public Long count(String... keys) {
        return redisTemplate.opsForHyperLogLog().size(keys);
    }

    // PFMERGE destkey sourcekey [sourcekey ...]
    public Long merge(String destination, String... sourceKeys) {
        return redisTemplate.opsForHyperLogLog().union(destination, sourceKeys);
    }

    // DEL key (HyperLogLog is stored as a String)
    public void delete(String key) {
        redisTemplate.opsForHyperLogLog().delete(key);
    }
}
