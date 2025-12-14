# Redis Spring Boot Enhanced Demo

This project demonstrates how to use Redis with Spring Boot, covering **all major data structures** and operations.

## Features & Supported Commands

### 1. Redis Strings
Strings are the most basic key-value store operation in Redis. They are binary safe and can hold any data, e.g., text, serialized objects, or counters.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `SET` | `set` | `POST /redis/string/set/{key}` | Set a key to hold a string value. | `SET mykey "Hello"` |
| `SET EX` | `set (with timeout)` | `POST /redis/string/setWithExpire/{key}` | Set the value and expiration of a key. | `SET mykey "Hello" EX 10` |
| `SETNX` | `setIfAbsent` | N/A (Service only) | Set the value of a key, only if the key does not exist. | `SETNX mykey "Hello"` |
| `GET` | `get` | `GET /redis/string/get/{key}` | Get the value of a key. | `GET mykey` |
| `INCR` | `increment` | `POST /redis/string/incr/{key}` | Increment the integer value of a key by one. | `INCR mycounter` |
| `DECR` | `decrement` | `POST /redis/string/decr/{key}` | Decrement the integer value of a key by one. | `DECR mycounter` |
| `APPEND` | `append` | `POST /redis/string/append/{key}` | Append a value to a key. | `APPEND mykey " World"` |

### 2. Redis Lists
Redis Lists are simply lists of strings, sorted by insertion order. You can add elements to the head (left) or tail (right) of the list.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `LPUSH` | `lPush` | `POST /redis/list/lpush/{key}` | Insert all the specified values at the head of the list. | `LPUSH mylist "world"` |
| `RPUSH` | `rPush` | `POST /redis/list/rpush/{key}` | Insert all the specified values at the tail of the list. | `RPUSH mylist "hello"` |
| `LPOP` | `lPop` | `GET /redis/list/lpop/{key}` | Removes and returns the first element of the list. | `LPOP mylist` |
| `RPOP` | `rPop` | `GET /redis/list/rpop/{key}` | Removes and returns the last element of the list. | `RPOP mylist` |
| `LRANGE` | `lRange` | `GET /redis/list/range/{key}` | Returns the specified elements of the list stored at key. | `LRANGE mylist 0 -1` |
| `LLEN` | `size` | `GET /redis/list/size/{key}` | Returns the length of the list. | `LLEN mylist` |

### 3. Redis Sets
Redis Sets are an unordered collection of unique strings. You can add, remove, and test for existence of members.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `SADD` | `add` | `POST /redis/set/add/{key}` | Add the specified members to the set stored at key. | `SADD myset "Hello"` |
| `SREM` | `remove` | `DELETE /redis/set/remove/{key}` | Remove the specified members from the set stored at key. | `SREM myset "Hello"` |
| `SMEMBERS` | `members` | `GET /redis/set/members/{key}` | Get all the members of the set value stored at key. | `SMEMBERS myset` |
| `SISMEMBER` | `isMember` | `POST /redis/set/ismember/{key}` | Determine if a given value is a member of the set. | `SISMEMBER myset "Hello"` |
| `SUNION` | `union` | `GET /redis/set/union/{key1}/{key2}` | Add multiple sets. | `SUNION myset1 myset2` |
| `SINTER` | `intersect` | `GET /redis/set/intersect/{key1}/{key2}` | Intersect multiple sets. | `SINTER myset1 myset2` |
| `SDIFF` | `difference` | `GET /redis/set/difference/{key1}/{key2}` | Subtract multiple sets. | `SDIFF myset1 myset2` |

### 4. Redis Hashes
Redis Hashes are maps between string fields and string values, so they are the perfect data type to represent objects (e.g., a User with name, surname, age).

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `HSET` | `put` | `POST /redis/hash/put/{key}` | Set the string value of a hash field. | `HSET myhash field1 "Hello"` |
| `HMSET` | `putAll` | `POST /redis/hash/putAll/{key}` | Set multiple hash fields to multiple values. | `HMSET myhash field1 "Hello" field2 "World"` |
| `HGET` | `get` | `GET /redis/hash/get/{key}/{hashKey}` | Get the value of a hash field. | `HGET myhash field1` |
| `HGETALL` | `entries` | `GET /redis/hash/entries/{key}` | Get all the fields and values in a hash. | `HGETALL myhash` |
| `HKEYS` | `keys` | `GET /redis/hash/keys/{key}` | Get all the fields in a hash. | `HKEYS myhash` |
| `HVALS` | `values` | `GET /redis/hash/values/{key}` | Get all the values in a hash. | `HVALS myhash` |
| `HDEL` | `delete` | `DELETE /redis/hash/delete/{key}` | Delete one or more hash fields. | `HDEL myhash field1` |
| `HEXISTS` | `hasKey` | `GET /redis/hash/hasKey/{key}/{hashKey}` | Determine if a hash field exists. | `HEXISTS myhash field1` |

### 5. Redis Sorted Sets (ZSheets)
Sorted Sets are similar to Sets but every member is associated with a score, that is used in order to take the sorted set ordered, from the smallest to the greatest score.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `ZADD` | `add` | `POST /redis/zset/add/{key}` | Add one or more members to a sorted set, or update its score if it already exists. | `ZADD myzset 1 "one"` |
| `ZREM` | `remove` | `DELETE /redis/zset/remove/{key}` | Remove one or more members from a sorted set. | `ZREM myzset "two"` |
| `ZRANGE` | `range` | `GET /redis/zset/range/{key}` | Return a range of members in a sorted set, by index. | `ZRANGE myzset 0 -1` |
| `ZREVRANGE` | `reverseRange` | `GET /redis/zset/reverseRange/{key}` | Return a range of members in a sorted set, by index, with scores ordered from high to low. | `ZREVRANGE myzset 0 -1` |
| `ZRANK` | `rank` | `POST /redis/zset/rank/{key}` | Determine the index of a member in a sorted set. | `ZRANK myzset "one"` |
| `ZSCORE` | `score` | `POST /redis/zset/score/{key}` | Get the score associated with the given member in a sorted set. | `ZSCORE myzset "one"` |
| `ZCOUNT` | `count` | `GET /redis/zset/count/{key}` | Count the members in a sorted set with scores within the given values. | `ZCOUNT myzset 0 10` |

### 6. Redis Geo
Redis Geo allows you to store geospatial items (latitude, longitude, name) and perform queries like distance between members or finding members within a radius.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `GEOADD` | `add` | `POST /redis/geo/add/{key}` | Add one or more geospatial items in the geospatial index. | `GEOADD Sicily 13.361389 38.115556 "Palermo" 15.087269 37.502669 "Catania"` |
| `GEODIST` | `distance` | `GET /redis/geo/dist/{key}/{m1}/{m2}` | Returns the distance between two members of a geospatial index. | `GEODIST Sicily Palermo Catania` |
| `GEOPOS` | `position` | `GET /redis/geo/pos/{key}` | Returns longitude and latitude of members of a geospatial index. | `GEOPOS Sicily Palermo Catania` |
| `GEOHASH` | `hash` | `GET /redis/geo/hash/{key}` | Returns value is a geohash string. | `GEOHASH Sicily Palermo Catania` |
| `GEORADIUS` | `radius` | `GET /redis/geo/radiusByMember/{key}/{member}` | Query a sorted set representing a geospatial index to fetch members inside an area of a circular shape. | `GEORADIUS Sicily 15 37 100 km` |

### 7. Redis HyperLogLog
HyperLogLog is a probabilistic data structure used in order to count unique things (technically this is referred to estimating the cardinality of a set).

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `PFADD` | `add` | `POST /redis/hll/add/{key}` | Adds the specified elements to the specified HyperLogLog. | `PFADD hll a b c d` |
| `PFCOUNT` | `count` | `GET /redis/hll/count` | Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s). | `PFCOUNT hll` |
| `PFMERGE` | `merge` | `POST /redis/hll/merge/{destination}` | Merge N different HyperLogLogs into a single one. | `PFMERGE hll3 hll1 hll2` |

### 8. Generic Key Operations
These commands operate on any key, regardless of the data structure stored at that key.

| Redis Command | Method | Endpoint | Description | Usage Example |
|---|---|---|---|---|
| `DEL` | `delete` | `DELETE /redis/key/delete/{key}` | Delete a key. | `DEL mykey` |
| `EXISTS` | `hasKey` | `GET /redis/key/exists/{key}` | Determine if a key exists. | `EXISTS mykey` |
| `EXPIRE` | `expire` | `POST /redis/key/expire/{key}` | Set a key's time to live in seconds. | `EXPIRE mykey 10` |
| `TTL` | `getExpire` | `GET /redis/key/ttl/{key}` | Get the time to live for a key. | `TTL mykey` |
| `TYPE` | `type` | `GET /redis/key/type/{key}` | Determine the type stored at key. | `TYPE mykey` |
| `KEYS` | `keys` | `GET /redis/key/keys` | Find all keys matching the given pattern. | `KEYS *` |

## Build and Run

```sh
mvn spring-boot:run
```

Ensure you have a Redis server running on `localhost:6379`.