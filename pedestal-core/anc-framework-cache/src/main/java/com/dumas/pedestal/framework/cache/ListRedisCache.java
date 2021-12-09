package com.dumas.pedestal.framework.cache;

import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 */
@Component
public class ListRedisCache extends BaseRawRedisCache {


    public long size(String key) {
        return execute(connection -> connection.listCommands().lLen(rawKey(key)));
    }

    /**
     * 移除list 所有 值为Key 的值
     *
     * @param key
     * @param value
     */
    public void lremAll(String key, Object value) {
        execute(connection -> connection.listCommands().lRem(rawKey(key), 0, serialize(value)));
    }

    public void lpush(String key, Object value) {
        execute(connection -> connection.listCommands().lPush(rawKey(key), serialize(value)));
    }

    public void clearList(String key) {
        ltrim(key, 1L, 0L);
    }

    public void ltrim(String key, long start, long end) {
        execute(connection -> {
            connection.listCommands().lTrim(rawKey(key), start, end);
            return null;
        });
    }

    public <T> void rPushAll(String key, List<T> ids) {
        byte[][] list = ids.stream().map(id -> serialize(id)).toArray(byte[][]::new);
        execute(connection -> connection.listCommands().rPush(rawKey(key), list));
    }

    public <T> List<T> lrangeAll(String key, Class<T> t) {
        return execute(connection -> SerializationUtils.deserialize(connection.listCommands().lRange(rawKey(key), 0, -1), getSerializer(t)));
    }

    public <T> List<T> lrange(String key, long start, long end, Class<T> t) {
        return execute(connection -> SerializationUtils.deserialize(connection.listCommands().lRange(rawKey(key), start, end), getSerializer(t)));
    }
}
