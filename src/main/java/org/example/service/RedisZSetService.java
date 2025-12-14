package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisZSetService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // ZADD key score member
    public Boolean add(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    // ZREM key member [member ...]
    public Long remove(String key, Object... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    // ZSCORE key member
    public Double score(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    // ZRANK key member
    public Long rank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    // ZREVRANK key member
    public Long reverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    // ZRANGE key start stop
    public Set<Object> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    // ZREVRANGE key start stop
    public Set<Object> reverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    // ZCOUNT key min max
    public Long count(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    // ZCARD key
    public Long size(String key) {
        return redisTemplate.opsForZSet().size(key);
    }
}
