package com.dumas.pedestal.framework.cache.util;

/**
 * TODO
 *
 * @author andaren
 * @version V1.0
 * @since 2020-09-02 10:56
 */
public class KeyUtil {
    private static final String REDIS_KEY_PRFIX = "{";
    private static final String REDIS_KEY_SUFFIX = "}";

    public static String replaceKey(String source, String keyName, String newVal) {
        if (null == source) {
            return "";
        }
        return source.replace(REDIS_KEY_PRFIX + keyName + REDIS_KEY_SUFFIX, newVal);
    }
}
