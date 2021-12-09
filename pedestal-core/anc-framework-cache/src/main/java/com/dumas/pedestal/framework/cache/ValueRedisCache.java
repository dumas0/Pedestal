package com.dumas.pedestal.framework.cache;


import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * kv redis 类型处理
 */
@Component
public class ValueRedisCache extends BaseRawRedisCache {


    public void set(String key, Object value) {
        execute(connection -> connection.set(rawKey(key), serialize(value)));
    }

    public boolean set(String key, Object value, long timeout, TimeUnit unit) {
        byte[] rawKey = rawKey(key);
        byte[] rawValue = serialize(value);
        Expiration expiration = Expiration.from(timeout, unit);
        return execute(connection -> connection.set(rawKey, rawValue, expiration, RedisStringCommands.SetOption.upsert()));
    }

    public <T> T get(String key, Class<T> t) {
        return execute(connection -> deserialize(connection.get(rawKey(key)), t));
    }

    public boolean exist(String key) {
        return execute(connection -> connection.exists(rawKey(key)));
    }

    public Boolean setIfAbsent(String key, Object value, long timeout, TimeUnit unit) {
        byte[] rawKey = rawKey(key);
        byte[] rawValue = serialize(value);
        Expiration expiration = Expiration.from(timeout, unit);
        return execute(connection -> connection.set(rawKey, rawValue, expiration, RedisStringCommands.SetOption.ifAbsent()));
    }

    public Long ttl(String key) {
        byte[] rawKey = rawKey(key);
        return execute(connection -> connection.ttl(rawKey));
    }

    public Long incr(String key) {
        return execute(connection -> connection.incr(rawKey(key)));
    }

    public Long decr(String key) {
        return execute(connection -> connection.decr(rawKey(key)));
    }
}
