package org.example.controller;

import org.example.service.RedisHyperLogLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/hll")
public class RedisHyperLogLogController {

    private final RedisHyperLogLogService redisHyperLogLogService;

    public RedisHyperLogLogController(RedisHyperLogLogService redisHyperLogLogService) {
        this.redisHyperLogLogService = redisHyperLogLogService;
    }

    @PostMapping("/add/{key}")
    public Long add(@PathVariable String key, @RequestBody Object[] values) {
        return redisHyperLogLogService.add(key, values);
    }

    @GetMapping("/count")
    public Long count(@RequestParam String[] keys) {
        return redisHyperLogLogService.count(keys);
    }

    @PostMapping("/merge/{destination}")
    public Long merge(@PathVariable String destination, @RequestParam String[] sourceKeys) {
        return redisHyperLogLogService.merge(destination, sourceKeys);
    }

    @DeleteMapping("/delete/{key}")
    public void delete(@PathVariable String key) {
        redisHyperLogLogService.delete(key);
    }
}
