package com.dumas.pedestal.common.model.api.vo;

import com.dumas.pedestal.common.model.constant.enums.CommonResponseCode;
import com.dumas.pedestal.common.model.inf.ResponseCode;

import java.util.Objects;

/**
 * api 接口调用失败
 *  当出现 业务异常 时调用该工厂方法，创建返回结构
 *
 * @author dumas
 * @date 2021/12/06 10:56 AM
 */
public class Fail {
    private Fail() {
        throw new AssertionError();
    }

    /**
     * 根据业务异常常量创建
     *
     * @param responseCode
     * @return
     */
    public static <T> R<T> ofRespCode(ResponseCode responseCode) {
        if (Objects.nonNull(responseCode) && CommonResponseCode.SUCCESS.code().equals(responseCode.code())) {
            throw new IllegalArgumentException("api调用失败时，不能返回成功");
        }

        return RFactory.fromResponseCode(responseCode);
    }

    /**
     * 根据业务异常信息创建
     * 尽量不调用这个接口
     *
     * @param errorMsg
     * @return
     */
    public static <T> R<T> ofMsg(String errorMsg) {
        R<T> response = RFactory.fromResponseCode(CommonResponseCode.EXCEPTION);
        if (Objects.nonNull(errorMsg)) {
            response.setMsg(errorMsg);
        }
        return response;
    }

    public static <T> R<T> error(String code, String msg) {
        Objects.requireNonNull(code);

        R<T> response = new R<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setSuccess(false);
        response.setData(null);
        return response;
    }
}
