package org.example.controller;

import org.example.service.RedisGetService;
import org.example.service.RedisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisGet")
public class RedisGetController {

    private final RedisGetService redisService;

    public RedisGetController(RedisGetService redisService) {
        this.redisService = redisService;
    }

    // 1. GET
    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        return redisService.getValue(key);
    }

    // 2. GETRANGE
    @GetMapping("/getrange/{key}")
    public String getRange(@PathVariable String key,
                           @RequestParam long start,
                           @RequestParam long end) {
        return redisService.getRange(key, start, end);
    }

    // 3. GETDEL
    @DeleteMapping("/getdel/{key}")
    public String getAndDelete(@PathVariable String key) {
        return redisService.getAndDelete(key);
    }

    // 4. GETEX
//    @GetMapping("/getex/{key}")
//    public String getAndExpire(@PathVariable String key,
//                               @RequestParam long timeout,
//                               @RequestParam(defaultValue = "SECONDS") TimeUnit unit) {
//        return redisService.getAndExpire(key, timeout, unit);
//    }

    // 5. MGET
    @PostMapping("/mget")
    public List<String> mget(@RequestBody List<String> keys) {
        return redisService.mget(keys);
    }

    // 6. GETBIT
    @GetMapping("/getbit/{key}")
    public int getBit(@PathVariable String key, @RequestParam long offset) {
        return redisService.getBit(key, offset);
    }

    // 7. STRLEN
    @GetMapping("/strlen/{key}")
    public long getLength(@PathVariable String key) {
        return redisService.getLength(key);
    }
}
