package com.dumas.pedestal.framework.springboot.web.intercepter.bo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author jy.cui
 * @version 1.0
 * @date 2021/4/8 14:13
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginInfoBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户Token
     */
    private String token;
    /**
     * 用户账号
     */
    private Long account;
    /**
     * 终端类型
     */
    private Integer clientType;
    /**
     * 设备指纹
     */
    private String deviceId;
    /**
    * 用户类型
    */
    private Integer userType;
    /**
     * memberId
     */
    private Long memberId;
    /**
     * 登录时间
     */
    private Long loginTime;
    /**
     * 过期时间
     */
    private Long expireTime;

}
