package org.example.controller;

import org.example.service.RedisZSetService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/redis/zset")
public class RedisZSetController {

    private final RedisZSetService redisZSetService;

    public RedisZSetController(RedisZSetService redisZSetService) {
        this.redisZSetService = redisZSetService;
    }

    @PostMapping("/add/{key}")
    public Boolean add(@PathVariable String key, @RequestBody Object value, @RequestParam double score) {
        return redisZSetService.add(key, value, score);
    }

    @DeleteMapping("/remove/{key}")
    public Long remove(@PathVariable String key, @RequestBody Object[] values) {
        return redisZSetService.remove(key, values);
    }

    @PostMapping("/score/{key}")
    public Double score(@PathVariable String key, @RequestBody Object value) {
        return redisZSetService.score(key, value);
    }

    @PostMapping("/rank/{key}")
    public Long rank(@PathVariable String key, @RequestBody Object value) {
        return redisZSetService.rank(key, value);
    }

    @PostMapping("/reverseRank/{key}")
    public Long reverseRank(@PathVariable String key, @RequestBody Object value) {
        return redisZSetService.reverseRank(key, value);
    }

    @GetMapping("/range/{key}")
    public Set<Object> range(@PathVariable String key, @RequestParam(defaultValue = "0") long start,
            @RequestParam(defaultValue = "-1") long end) {
        return redisZSetService.range(key, start, end);
    }

    @GetMapping("/reverseRange/{key}")
    public Set<Object> reverseRange(@PathVariable String key, @RequestParam(defaultValue = "0") long start,
            @RequestParam(defaultValue = "-1") long end) {
        return redisZSetService.reverseRange(key, start, end);
    }

    @GetMapping("/count/{key}")
    public Long count(@PathVariable String key, @RequestParam double min, @RequestParam double max) {
        return redisZSetService.count(key, min, max);
    }

    @GetMapping("/size/{key}")
    public Long size(@PathVariable String key) {
        return redisZSetService.size(key);
    }
}
