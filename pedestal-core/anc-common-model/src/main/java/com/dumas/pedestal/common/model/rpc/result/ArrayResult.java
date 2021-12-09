package com.dumas.pedestal.common.model.rpc.result;

import com.dumas.pedestal.common.model.constant.CommonApiConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * 数据数据返回
 *
 * @author dumas
 * @date 2021/12/06 11:10 AM
 */
@Setter
@Getter
@ToString
public class ArrayResult<T> implements Serializable {
    /**
     * 返回码
     * 0: 成功
     */
    private String code;

    /**
     * 返回描述
     * （记录接口执行情况说明信息）
     */
    private String msg;

    /**
     * data数组
     */
    private T[] data;

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSucceed() {
        return CommonApiConstant.API_RESPONSE_SUCCESS_CODE.equals(code);
    }

    /**
     * 是否空
     *
     * @return
     */
    public boolean isEmptyList() {
        return Objects.nonNull(data) && data.length > 0;
    }
}
