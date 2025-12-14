package org.example.controller;

import org.example.service.RedisStringService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis/string")
public class RedisStringController {

    private final RedisStringService redisStringService;

    public RedisStringController(RedisStringService redisStringService) {
        this.redisStringService = redisStringService;
    }

    @PostMapping("/set/{key}")
    public void set(@PathVariable String key, @RequestBody Object value) {
        redisStringService.set(key, value);
    }

    @PostMapping("/setWithExpire/{key}")
    public void set(@PathVariable String key, @RequestBody Object value, @RequestParam long timeout,
            @RequestParam TimeUnit unit) {
        redisStringService.set(key, value, timeout, unit);
    }

    @GetMapping("/get/{key}")
    public Object get(@PathVariable String key) {
        return redisStringService.get(key);
    }

    @PostMapping("/incr/{key}")
    public Long increment(@PathVariable String key, @RequestParam(defaultValue = "1") long delta) {
        return redisStringService.increment(key, delta);
    }

    @PostMapping("/decr/{key}")
    public Long decrement(@PathVariable String key, @RequestParam(defaultValue = "1") long delta) {
        return redisStringService.decrement(key, delta);
    }

    @PostMapping("/append/{key}")
    public Integer append(@PathVariable String key, @RequestBody String value) {
        return redisStringService.append(key, value);
    }
}
