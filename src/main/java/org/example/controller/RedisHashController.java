package org.example.controller;

import org.example.service.RedisHashService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/redis/hash")
public class RedisHashController {

    private final RedisHashService redisHashService;

    public RedisHashController(RedisHashService redisHashService) {
        this.redisHashService = redisHashService;
    }

    @PostMapping("/put/{key}")
    public void put(@PathVariable String key, @RequestParam String hashKey, @RequestBody Object value) {
        redisHashService.put(key, hashKey, value);
    }

    @PostMapping("/putAll/{key}")
    public void putAll(@PathVariable String key, @RequestBody Map<String, Object> map) {
        redisHashService.putAll(key, map);
    }

    @GetMapping("/get/{key}/{hashKey}")
    public Object get(@PathVariable String key, @PathVariable String hashKey) {
        return redisHashService.get(key, hashKey);
    }

    @DeleteMapping("/delete/{key}")
    public Long delete(@PathVariable String key, @RequestBody Object[] hashKeys) {
        return redisHashService.delete(key, hashKeys);
    }

    @GetMapping("/keys/{key}")
    public Set<Object> keys(@PathVariable String key) {
        return redisHashService.keys(key);
    }

    @GetMapping("/values/{key}")
    public List<Object> values(@PathVariable String key) {
        return redisHashService.values(key);
    }

    @GetMapping("/entries/{key}")
    public Map<Object, Object> entries(@PathVariable String key) {
        return redisHashService.entries(key);
    }

    @GetMapping("/size/{key}")
    public Long size(@PathVariable String key) {
        return redisHashService.size(key);
    }

    @GetMapping("/hasKey/{key}/{hashKey}")
    public Boolean hasKey(@PathVariable String key, @PathVariable String hashKey) {
        return redisHashService.hasKey(key, hashKey);
    }
}
