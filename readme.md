✅ Summary of GET Variants

| Command  | Purpose                        |
|----------|-------------------------------|
| GET      | Get full value                |
| GETRANGE | Get substring by index        |
| GETDEL   | Get value and delete key      |
| GETEX    | Get value and update TTL      |
| MGET     | Get multiple keys at once     |
| GETBIT   | Get a bit from binary value   |
| STRLEN   | Get length of string          |


| Redis Option            | Spring Boot / Java Equivalent                                         |
|-------------------------|-----------------------------------------------------------------------|
| `SET key value`         | `redisTemplate.opsForValue().set(key, value)`                         |
| `SET key value EX 60`   | `redisTemplate.opsForValue().set(key, value, 60, TimeUnit.SECONDS)`   |
| `NX`                    | `setIfAbsent(key, value, timeout, unit)`                              |
| `XX`                    | `setIfPresent(key, value, timeout, unit)`                             |
| `KEEPTTL`               | Use `SetArgs.keepttl()` with Lettuce low-level API                    |
| `GET`                   | Use `SetArgs.get()` with Lettuce low-level API                        |
| `PX`, `PXAT`, `EXAT`    | Use `SetArgs` (Lettuce) for fine-grained expiry                       |

| Command     | Purpose                                   |
|-------------|-------------------------------------------|
| DEL         | Delete key(s) immediately                 |
| UNLINK      | Async delete (non-blocking)               |
| FLUSHDB     | Delete all keys in current DB             |
| FLUSHALL    | Delete all keys in all DBs                |
| EXPIRE      | Set expiry in seconds                     |
| PEXPIRE     | Set expiry in milliseconds                |
| EXPIREAT    | Expire at UNIX time (seconds)             |
| PEXPIREAT   | Expire at UNIX time (milliseconds)        |
| PERSIST     | Remove TTL (cancel expiry)                |