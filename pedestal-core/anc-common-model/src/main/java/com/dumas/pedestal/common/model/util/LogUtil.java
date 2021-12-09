package com.dumas.pedestal.common.model.util;

import com.dumas.pedestal.common.model.api.vo.R;

import java.util.Objects;

/**
 * 日志工具
 *
 * @author dumas
 * @date 2021/12/06 10:38 AM
 */
public class LogUtil {
    public static String errorMsgFromR(R result) {
        return Objects.isNull(result) ? "返回为空" : result.getMsg();
    }
}
