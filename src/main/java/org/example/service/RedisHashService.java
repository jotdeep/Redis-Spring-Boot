package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisHashService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // HSET key field value
    public void put(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    // HMSET key field value [field value ...]
    public void putAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    // HGET key field
    public Object get(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    // HDEL key field [field ...]
    public Long delete(String key, Object... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    // HKEYS key
    public Set<Object> keys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    // HVALS key
    public List<Object> values(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    // HGETALL key
    public Map<Object, Object> entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // HLEN key
    public Long size(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    // HEXISTS key field
    public Boolean hasKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }
}
