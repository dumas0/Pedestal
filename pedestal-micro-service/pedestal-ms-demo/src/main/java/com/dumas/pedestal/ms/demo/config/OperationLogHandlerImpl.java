package com.dumas.pedestal.ms.demo.config;

import com.dumas.pedestal.framework.logger.BusinessLogger;
import com.dumas.pedestal.framework.springboot.web.intercepter.OperationLog;
import com.dumas.pedestal.framework.springboot.web.intercepter.OperationLogHandler;

/**
 * @author dumas
 * @date 2022/01/10 2:04 PM
 */
public class OperationLogHandlerImpl implements OperationLogHandler {
    @Override
    public void handleOperationLog(OperationLog operationLog) {
        //日志打印在 //"${LOG_PATH}/${LOG_CONTEXT_NAME}${BUSINESS_DIR}" exam:\pedestal\logs\pedestal-ms-demo\business\pedestal-ms-demo.business.log
        BusinessLogger.getLogger().info(operationLog.printLog());
    }
}
