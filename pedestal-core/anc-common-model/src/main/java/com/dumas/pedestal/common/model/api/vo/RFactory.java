package com.dumas.pedestal.common.model.api.vo;

import com.dumas.pedestal.common.model.constant.enums.CommonResponseCode;
import com.dumas.pedestal.common.model.inf.ResponseCode;

import java.util.Objects;

/**
 * NormalR 构造器
 *
 * @author dumas
 * @date 2021/12/06 10:39 AM
 */
public class RFactory {
    private RFactory() {
        throw new AssertionError();
    }

    public static <T> R<T> fromResponseCode(ResponseCode responseCode) {
        Objects.requireNonNull(responseCode);

        R<T> response = new R<>();
        response.setCode(responseCode.code());
        response.setMsg(responseCode.msg());

        boolean isSucceed = CommonResponseCode.SUCCESS.code().equals(responseCode.code());
        response.setSuccess(isSucceed);
        if (!isSucceed) {
            response.setData(null);
        }
        return response;
    }
}
