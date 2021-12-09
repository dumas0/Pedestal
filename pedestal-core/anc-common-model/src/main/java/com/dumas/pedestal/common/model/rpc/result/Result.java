package com.dumas.pedestal.common.model.rpc.result;

import com.dumas.pedestal.common.model.constant.CommonApiConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 单条数据返回
 *
 * @author dumas
 * @date 2021/12/06 11:02 AM
 */
@Getter
@Setter
@ToString
public class Result<T> implements Serializable {
    /**
     * 返回码
     * 0: 成功
     * 其他参考
     */
    private String code;

    /**
     * 返回描述
     * （记录接口执行情况说明信息）
     */
    private String msg;

    private T data;

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSucceed() {
        return CommonApiConstant.API_RESPONSE_SUCCESS_CODE.equals(code);
    }

    public static <T> Result<T> ofSuccess() {
        Result<T> result = new Result<>();
        result.setCode(CommonApiConstant.API_RESPONSE_SUCCESS_CODE);
        result.setMsg("操作成功");
        result.setData(null);
        return result;
    }

    public static <T> Result<T> ofSuccess(T data) {
        Result<T> result = new Result<>();
        result.setCode(CommonApiConstant.API_RESPONSE_SUCCESS_CODE);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> ofFail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(CommonApiConstant.API_RESPONSE_EXCEPTION_CODE);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> ofFail(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
