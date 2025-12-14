package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisSetService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // SADD key member [member ...]
    public Long add(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    // SREM key member [member ...]
    public Long remove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    // SMEMBERS key
    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // SISMEMBER key member
    public Boolean isMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    // SCARD key
    public Long size(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    // SUNION key [key ...]
    public Set<Object> union(String key, String otherKey) {
        return redisTemplate.opsForSet().union(key, otherKey);
    }

    // SINTER key [key ...]
    public Set<Object> intersect(String key, String otherKey) {
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }

    // SDIFF key [key ...]
    public Set<Object> difference(String key, String otherKey) {
        return redisTemplate.opsForSet().difference(key, otherKey);
    }
}
