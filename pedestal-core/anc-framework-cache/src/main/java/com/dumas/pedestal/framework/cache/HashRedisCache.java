package com.dumas.pedestal.framework.cache;

import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * hash redis opreations
 */
@Component
public class HashRedisCache extends BaseRawRedisCache {

    public void put(String key, String hashKey, Object hashValue) {
        execute(connection -> connection.hashCommands().hSet(rawKey(key), rawKey(hashKey), serialize(hashValue)));
    }

    public <T> T get(String key, String hashKey, Class<T> t) {
        return execute(connection -> deserialize(connection.hashCommands().hGet(rawKey(key), rawKey(hashKey)), t));
    }

    public boolean exist(String key, String hashKey) {
        return execute(connection -> connection.hashCommands().hExists(rawKey(key), rawKey(hashKey)));
    }

    public <T> Map<String, T> getAll(String key, Class<T> t) {
        return execute(connection -> {
            Map<byte[], byte[]> map = connection.hashCommands().hGetAll(rawKey(key));
            if (map == null) {
                return null;
            }
            Map<String, T> sourceMap = new HashMap<>(map.size());
            map.entrySet().stream().forEach(entry -> sourceMap.put(deserialize(entry.getKey(), String.class), deserialize(entry.getValue(), t)));
            return sourceMap;
        });
    }

    public void hrem(String key, String hashKey) {
        execute(connection -> connection.hashCommands().hDel(rawKey(key), new byte[][]{rawKey(hashKey)}));
    }

    public boolean hexit(String key, String hashKey) {
        return execute(connection -> connection.hashCommands().hExists(rawKey(key), rawKey(hashKey)));
    }

    public <T> void putAll(String key, Map<String, T> map) {
        Map<byte[], byte[]> sourceMap = new HashMap<>(map.size());
        map.entrySet().stream().forEach(entry -> sourceMap.put(rawKey(entry.getKey()), serialize(entry.getValue())));
        execute(connection -> {
            connection.hashCommands().hMSet(rawKey(key), sourceMap);
            return null;
        });
    }

    public <T> List<T> multiGet(String key, List<String> appKeys, Class<T> t) {
        byte[][] list = appKeys.stream().map(appKey -> rawKey(appKey)).toArray(byte[][]::new);
        return execute(connection -> SerializationUtils.deserialize(connection.hashCommands().hMGet(rawKey(key), list), getSerializer(t)));
    }

    public Long increment(String key, Object field, int offset) {
        return execute(connection -> connection.hashCommands().hIncrBy(rawKey(key), serialize(field), offset));
    }

    public <T> Map<T, T> hGetAll(String key, Class<T> t) {
        return execute(connection -> SerializationUtils.deserialize(connection.hashCommands().hGetAll(rawKey(key)), getSerializer(t)));
    }

    /**
     * 获取hash个数
     *
     * @param key
     * @return
     */
    public Long hLen(String key) {
        byte[] rawKey = rawKey(key);
        return execute(conection ->
                conection.hashCommands().hLen(rawKey)
        );
    }
}
