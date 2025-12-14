package org.example.controller;

import org.example.service.RedisGeoService;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis/geo")
public class RedisGeoController {

    private final RedisGeoService redisGeoService;

    public RedisGeoController(RedisGeoService redisGeoService) {
        this.redisGeoService = redisGeoService;
    }

    @PostMapping("/add/{key}")
    public Long add(@PathVariable String key, @RequestParam double x, @RequestParam double y,
            @RequestBody Object member) {
        return redisGeoService.add(key, new Point(x, y), member);
    }

    @GetMapping("/dist/{key}/{member1}/{member2}")
    public Distance distance(@PathVariable String key, @PathVariable String member1, @PathVariable String member2) {
        return redisGeoService.distance(key, member1, member2);
    }

    @GetMapping("/pos/{key}")
    public List<Point> position(@PathVariable String key, @RequestBody Object[] members) {
        return redisGeoService.position(key, members);
    }

    @GetMapping("/hash/{key}")
    public List<String> hash(@PathVariable String key, @RequestBody Object[] members) {
        return redisGeoService.hash(key, members);
    }

    @GetMapping("/radiusByMember/{key}/{member}")
    public Object radiusByMember(@PathVariable String key, @PathVariable String member, @RequestParam double radius) {
        return redisGeoService.radiusByMember(key, member, radius);
    }
}
