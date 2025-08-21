package org.example.controller;

import org.example.service.RedisDeleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisDeleteController {

    private final RedisDeleteService deleteService;

    public RedisDeleteController(RedisDeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping("/del/{key}")
    public boolean deleteKey(@PathVariable String key) {
        return deleteService.deleteKey(key);
    }

    @DeleteMapping("/del")
    public long deleteKeys(@RequestBody List<String> keys) {
        return deleteService.deleteKeys(keys);
    }

    @PostMapping("/expire/{key}")
    public boolean expireKey(@PathVariable String key,
                             @RequestParam long timeout,
                             @RequestParam(defaultValue = "SECONDS") TimeUnit unit) {
        return deleteService.expireKey(key, timeout, unit);
    }

    @PostMapping("/persist/{key}")
    public boolean persistKey(@PathVariable String key) {
        return deleteService.persistKey(key);
    }
}
