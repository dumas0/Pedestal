package com.dumas.pedestal.framework.mybatis.handler.autofill;

/**
 * 用于自动填充用户名
 *  依赖方可扩充该接口提供实现
 *
 * 默认实现: 无填充
 * @see com.dumas.pedestal.framework.mybatis.handler.autofill.DefaultFillUsernameHandler
 *
 * @author az.ye
 * @version V1.0
 * @since 2021-06-21 22:13
 */
public interface IFillUsernameHandler {

    /**
     * 获取用户名
     * @return
     */
    String getUsername();

}
