package com.dumas.pedestal.common.model.rpc.result;

import com.dumas.pedestal.common.model.constant.CommonApiConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页结果
 *
 * @author dumas
 * @date 2021/12/06 11:05 AM
 */
@Setter
@Getter
@ToString
public class PageResult<T> {
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

    private PageInfoDTO<T> data;

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSucceed() {
        return CommonApiConstant.API_RESPONSE_SUCCESS_CODE.equals(code);
    }
}
