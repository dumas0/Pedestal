package com.dumas.pedestal.framework.springboot.web.intercepter;

/**
 * 操作日志处理器
 *
 * @author az.ye
 * @version V1.0
 * @since 2021-04-14 14:38
 */
public interface OperationLogHandler {

    /**
     * 处理操作日志
     * @param operationLog
     */
    void handleOperationLog(OperationLog operationLog);
}
