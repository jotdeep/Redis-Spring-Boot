package org.example.controller;

import org.example.service.RedisSetService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/redis/set")
public class RedisSetController {

    private final RedisSetService redisSetService;

    public RedisSetController(RedisSetService redisSetService) {
        this.redisSetService = redisSetService;
    }

    @PostMapping("/add/{key}")
    public Long add(@PathVariable String key, @RequestBody Object[] values) {
        return redisSetService.add(key, values);
    }

    @DeleteMapping("/remove/{key}")
    public Long remove(@PathVariable String key, @RequestBody Object[] values) {
        return redisSetService.remove(key, values);
    }

    @GetMapping("/members/{key}")
    public Set<Object> members(@PathVariable String key) {
        return redisSetService.members(key);
    }

    @PostMapping("/ismember/{key}")
    public Boolean isMember(@PathVariable String key, @RequestBody Object value) {
        return redisSetService.isMember(key, value);
    }

    @GetMapping("/size/{key}")
    public Long size(@PathVariable String key) {
        return redisSetService.size(key);
    }

    @GetMapping("/union/{key1}/{key2}")
    public Set<Object> union(@PathVariable String key1, @PathVariable String key2) {
        return redisSetService.union(key1, key2);
    }

    @GetMapping("/intersect/{key1}/{key2}")
    public Set<Object> intersect(@PathVariable String key1, @PathVariable String key2) {
        return redisSetService.intersect(key1, key2);
    }

    @GetMapping("/difference/{key1}/{key2}")
    public Set<Object> difference(@PathVariable String key1, @PathVariable String key2) {
        return redisSetService.difference(key1, key2);
    }
}
