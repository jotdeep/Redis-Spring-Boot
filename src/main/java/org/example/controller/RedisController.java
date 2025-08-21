package org.example.controller;

import org.example.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final   RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisService.save(key, value);
        return "Saved key=" + key + " value=" + value;
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return redisService.    get(key);
    }

    @DeleteMapping("/delete/{key}")
    public String delete(@PathVariable String key) {
        redisService.delete(key);
        return "Deleted key=" + key;
    }
}
