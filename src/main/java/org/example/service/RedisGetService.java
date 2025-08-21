package org.example.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisGetService {

    private final StringRedisTemplate redisTemplate;

    public RedisGetService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 1. GET
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 2. GETRANGE
    public String getRange(String key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    // 3. GETDEL (requires Lettuce low-level API)
    public String getAndDelete(String key) {
        return redisTemplate.execute((RedisCallback<String>) connection -> {
            byte[] value = connection.stringCommands().getDel(key.getBytes(StandardCharsets.UTF_8));
            return value != null ? new String(value, StandardCharsets.UTF_8) : null;
        });
    }


    // 5. MGET
    public List<String> mget(List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    // 6. GETBIT
    public int getBit(String key, long offset) {
        Boolean bit = redisTemplate.opsForValue().getBit(key, offset);
        return Boolean.TRUE.equals(bit) ? 1 : 0;
    }

    // 7. STRLEN
    public long getLength(String key) {
        return redisTemplate.opsForValue().size(key);
    }
}
