package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisKeyService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // DEL key [key ...]
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // DEL key [key ...]
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    // EXISTS key
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    // EXPIRE key seconds
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    // EXPIREAT key timestamp
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    // TTL key
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    // TTL key
    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    // PERSIST key
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    // TYPE key
    public DataType type(String key) {
        return redisTemplate.type(key);
    }

    // KEYS pattern
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    // RENAME key newkey
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    // RENAMENX key newkey
    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }
}
