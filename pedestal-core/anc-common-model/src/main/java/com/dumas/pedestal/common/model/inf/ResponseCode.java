package com.dumas.pedestal.common.model.inf;

/**
 * 返回码
 * <p>返回码抽象接口:业务模块，实现该接口，定义自己业务内的异常信息</p>
 *
 * @author dumas
 * @date 2021/12/06 10:11 AM
 * @see com.dumas.pedestal.common.model.constant.enums.CommonResponseCode
 */
public interface ResponseCode {
    /**
     * 错误码
     *
     * @return
     */
    String code();

    /**
     * 错误信息
     *
     * @return
     */
    String msg();
}
