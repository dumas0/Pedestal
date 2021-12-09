package com.dumas.pedestal.framework.cache.helper;

import org.springframework.stereotype.Component;

/**
 * Redis锁辅助类
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-30 09:31
 */
@Component
public class RedisLockHelper {
    /**
     * 释放锁lua脚本
     */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    public boolean lockSetnx(String key, String value, int timeout) {

        return true;
    }

}
