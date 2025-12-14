package org.example.controller;

import org.example.service.RedisKeyService;
import org.springframework.data.redis.connection.DataType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis/key")
public class RedisKeyController {

    private final RedisKeyService redisKeyService;

    public RedisKeyController(RedisKeyService redisKeyService) {
        this.redisKeyService = redisKeyService;
    }

    @DeleteMapping("/delete/{key}")
    public void delete(@PathVariable String key) {
        redisKeyService.delete(key);
    }

    @GetMapping("/exists/{key}")
    public Boolean hasKey(@PathVariable String key) {
        return redisKeyService.hasKey(key);
    }

    @PostMapping("/expire/{key}")
    public Boolean expire(@PathVariable String key, @RequestParam long timeout, @RequestParam TimeUnit unit) {
        return redisKeyService.expire(key, timeout, unit);
    }

    @GetMapping("/ttl/{key}")
    public Long getExpire(@PathVariable String key) {
        return redisKeyService.getExpire(key);
    }

    @GetMapping("/type/{key}")
    public DataType type(@PathVariable String key) {
        return redisKeyService.type(key);
    }

    @GetMapping("/keys")
    public Set<String> keys(@RequestParam String pattern) {
        return redisKeyService.keys(pattern);
    }
}
