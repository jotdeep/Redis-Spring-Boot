package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisGeoService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // GEOADD key longitude latitude member
    public Long add(String key, Point point, Object member) {
        return redisTemplate.opsForGeo().add(key, point, member);
    }

    // GEOADD key longitude latitude member [longitude latitude member ...]
    public Long add(String key, java.util.Map<Object, Point> memberCoordinateMap) {
        return redisTemplate.opsForGeo().add(key, memberCoordinateMap);
    }

    // GEODIST key member1 member2 [m|km|ft|mi]
    public Distance distance(String key, Object member1, Object member2) {
        return redisTemplate.opsForGeo().distance(key, member1, member2);
    }

    // GEODIST with Metrics
    public Distance distance(String key, Object member1, Object member2, Metrics metric) {
        return redisTemplate.opsForGeo().distance(key, member1, member2, metric);
    }

    // GEOPOS key member [member ...]
    public List<Point> position(String key, Object... members) {
        return redisTemplate.opsForGeo().position(key, members);
    }

    // GEOHASH key member [member ...]
    public List<String> hash(String key, Object... members) {
        return redisTemplate.opsForGeo().hash(key, members);
    }

    // GEORADIUS key longitude latitude radius m|km|ft|mi
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> radius(String key, Circle within) {
        return redisTemplate.opsForGeo().radius(key, within);
    }

    // GEORADIUSBYMEMBER key member radius m|km|ft|mi
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> radiusByMember(String key, Object member, double radius) {
        return redisTemplate.opsForGeo().radius(key, member, radius);
    }
}
