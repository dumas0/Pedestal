package com.dumas.pedestal.framework.springboot.web.apicontrol.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * API 版本控制注解
 *
 * @author andaren
 * @version V1.0
 * @since 2020-05-12 16:33
 */
@Mapping
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ApiVersion {

    /**
     * version value
     *
     * @return version
     */
    int value();

}
