package com.dumas.pedestal.framework.springboot.web.intercepter.bo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * http请求信息
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-19 21:42
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestBO {
    /**
     * 是否打印请求信息
     */
    Boolean logReq;
    /**
     * 请求的URI
     */
    String reqUri;

    /**
     * http请求方法
     */
    String httpMethod;

}
