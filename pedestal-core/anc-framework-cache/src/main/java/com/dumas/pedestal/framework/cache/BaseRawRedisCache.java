package com.dumas.pedestal.framework.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.TimeUnit;


/**
 * @author Administrator
 * 自定义key、value序列化方式
 * 默认key hashKey 为是 StringRedisSerializer 序列化方式，须动态指定value的序列化方式
 */
public class BaseRawRedisCache {
    @Autowired
    protected RedisTemplate redisTemplate;
    /**
     * 数字类型的序列化和反序列化工具
     * integer
     */
    protected GenericToStringSerializer<Integer> numberRedisSerializer = new GenericToStringSerializer<>(Integer.class);
    /**
     * 数字类型的序列化和反序列化工具
     * long
     */
    protected GenericToStringSerializer<Long> longRedisSerializer = new GenericToStringSerializer<>(Long.class);
    /**
     * 字符串类型的序列化和反序列化工具
     * string
     */
    protected RedisSerializer<String> stringRedisSerializer = RedisSerializer.string();
    /**
     * 字节类型的序列化和反序列化工具
     * byte[] 无任何处理
     */
    protected RedisSerializer<byte[]> byteArrayRedisSerializer = RedisSerializer.byteArray();

    /**
     * key hashKey 默认用 StringRedisSerializer 序列化
     *
     * @param key
     * @return
     */
    public byte[] rawKey(String key) {
        return stringRedisSerializer.serialize(key);
    }

    /**
     * key hashKey 默认用 StringRedisSerializer 序列化
     * 多参数序列化，返回结果不同
     *
     * @param: keys :
     * @return: byte[][]
     */
    public byte[][] rawKey(String... keys) {
        byte[][] result = new byte[keys.length][];
        int i = 0;
        for (String key : keys) {
            result[i++] = stringRedisSerializer.serialize(key);
        }
        return result;
    }

    /**
     * 是否存在Key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        byte[] rawKey = rawKey(key);
        return execute(connection -> connection.exists(rawKey));
    }

    public Boolean expire(String key, long timeout, TimeUnit unit) {
        byte[] rawKey = rawKey(key);
        long rawTimeout = TimeoutUtils.toMillis(timeout, unit);
        return execute(connection -> {
            try {
                return connection.pExpire(rawKey, rawTimeout);
            } catch (Exception e) {
                // Driver may not support pExpire or we may be running on Redis 2.4
                return connection.expire(rawKey, TimeoutUtils.toSeconds(timeout, unit));
            }
        });
    }

    public boolean delete(String key) {
        byte[] rawKey = rawKey(key);
        Long result = execute(connection -> connection.del(rawKey));
        return result != null && result.intValue() == 1;
    }

    protected <T> T execute(RedisCallback<T> callback) {
        return (T) redisTemplate.execute(callback, true);
    }

    public <T> T executePipelined(RedisCallback<T> callback) {
        return (T) redisTemplate.executePipelined(callback, byteArrayRedisSerializer);
    }


    public byte[] serialize(Object t) {
        return getSerializer(t).serialize(t);
    }

    public <T> T deserialize(byte[] value, Class<T> t) {
        return (T) getSerializer(t).deserialize(value);
    }

    protected RedisSerializer getSerializer(Class<?> t) {
        if (Integer.class.isAssignableFrom(t)) {
            return numberRedisSerializer;
        } else if (String.class.isAssignableFrom(t)) {
            return stringRedisSerializer;
        } else if (byte[].class.isAssignableFrom(t)) {
            return byteArrayRedisSerializer;
        } else if (Long.class.isAssignableFrom(t)) {
            return longRedisSerializer;
        } else {
            throw new RuntimeException("不支持此类型反序列化-->" + t);
        }
    }

    protected RedisSerializer getSerializer(Object t) {
        return getSerializer(t.getClass());
    }

}
