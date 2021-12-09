package com.dumas.pedestal.framework.cache;

import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SetRedisCache extends BaseRawRedisCache {


    public boolean add(String key, Object value) {
        Long result = execute(connection -> connection.setCommands().sAdd(rawKey(key), serialize(value)));
        return result != null && result == 1;
    }

    public <T> void addAll(String key, List<T> ids) {
        byte[][] list = ids.stream().map(id -> serialize(id)).toArray(byte[][]::new);
        execute(connection -> connection.setCommands().sAdd(rawKey(key), list));
    }

    public <T> Set<T> list(String key, Class<T> t) {
        return execute(connection -> SerializationUtils.deserialize(connection.setCommands().sMembers(rawKey(key)), getSerializer(t)));
    }
}
