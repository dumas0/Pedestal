package com.dumas.pedestal.framework.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁注解
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-29 22:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLock {
    /**
     * 业务键
     *
     * @return
     */
    String key();

    /**
     * 锁的过期秒数,默认是5秒
     *
     * @return
     */
    int expire() default 5;

    /**
     * 尝试加锁，最多等待时间
     *
     * @return
     */
    long waitTime() default Long.MIN_VALUE;

    /**
     * 锁的超时时间单位
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 是否需要续锁
     *
     * @return
     */
    boolean needRelock() default false;
}
