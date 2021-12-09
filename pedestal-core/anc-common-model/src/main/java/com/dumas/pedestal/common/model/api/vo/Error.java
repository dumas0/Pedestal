package com.dumas.pedestal.common.model.api.vo;

import com.dumas.pedestal.common.model.constant.enums.CommonResponseCode;

import java.util.Objects;

/**
 * api 接口系统错误返回构造器
 * 当出现系统错误时调用该工厂方法，创建返回结构
 *
 * @author dumas
 * @date 2021/12/06 10:57 AM
 */
public class Error {
    private Error() {
        throw new AssertionError();
    }

    public static <T> R<T> ofMsg(String errorMsg) {
        R<T> response = RFactory.fromResponseCode(CommonResponseCode.ERROR);
        if (Objects.nonNull(errorMsg)) {
            response.setMsg(errorMsg);
        }
        return response;
    }

    public static <T> R<T> ofMsgAndCode(String msg, String code) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setSuccess(false);
        return r;
    }

    public static <T> R<T> fromCode(CommonResponseCode code) {
        return RFactory.fromResponseCode(code);
    }

}
