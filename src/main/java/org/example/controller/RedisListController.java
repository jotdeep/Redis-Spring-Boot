package org.example.controller;

import org.example.service.RedisListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis/list")
public class RedisListController {

    private final RedisListService redisListService;

    public RedisListController(RedisListService redisListService) {
        this.redisListService = redisListService;
    }

    @PostMapping("/lpush/{key}")
    public Long lPush(@PathVariable String key, @RequestBody Object value) {
        return redisListService.lPush(key, value);
    }

    @PostMapping("/rpush/{key}")
    public Long rPush(@PathVariable String key, @RequestBody Object value) {
        return redisListService.rPush(key, value);
    }

    @GetMapping("/lpop/{key}")
    public Object lPop(@PathVariable String key) {
        return redisListService.lPop(key);
    }

    @GetMapping("/rpop/{key}")
    public Object rPop(@PathVariable String key) {
        return redisListService.rPop(key);
    }

    @GetMapping("/range/{key}")
    public List<Object> lRange(@PathVariable String key, @RequestParam(defaultValue = "0") long start,
            @RequestParam(defaultValue = "-1") long end) {
        return redisListService.lRange(key, start, end);
    }

    @GetMapping("/size/{key}")
    public Long size(@PathVariable String key) {
        return redisListService.size(key);
    }
}
