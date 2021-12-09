package com.dumas.pedestal.framework.springboot.web.intercepter.bo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 操作方法
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-19 20:24
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MethodBO {
    /**
     * 是否打印方法信息
     */
    Boolean logMethod;
    /**
     * 类名
     */
    String className;

    /**
     * 方法名
     */
    String methodName;

    /**
     * 参数
     * @return
     */
    String param;

    /**
     * 返回
     * @return
     */
    Object result;

    /**
     * 是否抛出异常
     */
    boolean hadExp;

    /**
     * 异常信息
     */
    String expMsg;
}
