package com.dumas.pedestal.framework.springboot.web.annotation;

import com.dumas.pedestal.framework.springboot.constant.enums.BusinessType;
import com.dumas.pedestal.framework.springboot.constant.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 切面日志
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-19 19:52
 */
@Target({ ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {
    /**
     * 模块
     * @return
     */
    String module() default "";

    /**
     * 业务类型
     */
    BusinessType bizType() default BusinessType.OTHER;

    /**
     * 描述
     * @return
     */
    String description() default "";

    /**
     * 操作人员类别
     * @return
     */
    OperatorType operatorType() default OperatorType.OTHER;

    /**
     * 是否记录请求信息
     * @return
     */
    boolean logReq() default true;

    /**
     * 记录方法信息
     * @return
     */
    boolean logMethod() default true;

    /**
     * 是否记录操作人员
     * @return
     */
    boolean logOperator() default false;

}
