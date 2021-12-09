package com.dumas.pedestal.common.model.constant.enums;

import com.dumas.pedestal.common.model.inf.ResponseCode;

/**
 * 通用返回码
 * <p>业务无关，只定义所有业务都适用的返回码及返回码区间定义</p>
 *
 * @author dumas
 * @date 2021/12/06 10:07 AM
 */
public enum CommonResponseCode implements ResponseCode {
    //======================================================================
    // 系统内置
    //======================================================================
    /**
     * 返回成功
     */
    SUCCESS("0", "success"),

    /**
     * 内置错误
     * 区间[1000 ~ 10_000]
     */
    ERROR("1000", "系统错误"),

    //======================================================================
    // 业务方向
    //======================================================================
    /**
     * 请求参数异常
     * 区间 [50_000 ~ 60_000]
     */
    ILLEGAL_PARAM("50100", "参数不合法"),
    EMPTY_PARAM("50101", "参数为空"),
    REQUIRED_PARAM("50102", "缺少参数"),
    /**
     * 用户、账号异常
     * 区间[60_000 ~ 70_000]
     */
    GET_USER_INFO_FAIL("60008", "Login failed, unable to get user details"),
    USERNAME_NOT_EXISTED("60204", "用户名不存在"),
    PASSWORD_INCORRECT("60205", "密码不正确"),
    USER_NOT_AUTH("60206", "用户没有权限"),
    USER_NOT_LOGIN("60207", "用户未登录"),
    USER_BlOCK("60208", "用户状态异常"),
    USER_NO_LOGIN_AGENT("60209", "用户终端异常"),
    USER_LOGIN_INVALID("60210", "用户登录失效"),
    GUEST_LOGIN_INVALID("60211", "游客切换正式用户,登录失效"),
    GUEST_LOGINED("60212", "正式用户已登录"),
    USER_EXPIRE("60213", "用户已过期"),
    USER_HOST_ERR("60216", "用户域名不合法"),
    USER_NO_DEVICE("60214", "用户设备信息不存在"),
    USER_NO_EXIST("60217", "用户不存在"),

    /**
     * 第三方API异常
     * 区间[70_000 ~ 75_000]
     */
    THIRD_API_EXCEPTION("70001", "第三方API调用异常"),
    /**
     * 内部API异常
     * 区间[75_000 ~ 80_000]
     */
    INNER_API_EXCEPTION("75001", "内部API调用异常"),

    /**
     * 其他业务异常
     * 区间[100_000 ~ N00_000](N > 1)
     * 区间定义说明：各个微服务各自实现 ResponseCode 接口，每个微服务定义自己的业务异常回复码，号段在N上加一
     * 如：同一系统微服务群下，有A、B、C 三个服务，可以定义
     * A in [200_000 ~ 300_000)
     * B in [300_000 ~ 400_000)
     * A in [400_000 ~ 500_000)
     */
    RECORD_NOT_FOUNT("100215", "该条记录不存在"),
    /**
     * 业务无明确异常原因时使用，框架异常默认返回码
     */
    EXCEPTION("100500", "系统业务异常"),

    ;

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    CommonResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonResponseCode getByCode(String code) {
        for (CommonResponseCode e : CommonResponseCode.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}