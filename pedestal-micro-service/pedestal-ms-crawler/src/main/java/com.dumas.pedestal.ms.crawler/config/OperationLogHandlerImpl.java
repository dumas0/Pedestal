package com.dumas.pedestal.ms.crawler.config;

import com.dumas.pedestal.framework.logger.BusinessLogger;
import com.dumas.pedestal.framework.springboot.web.intercepter.OperationLog;
import com.dumas.pedestal.framework.springboot.web.intercepter.OperationLogHandler;
import org.springframework.stereotype.Component;

/**
 * @author dumas
 * @date 2022/01/07 4:29 PM
 */
@Component
public class OperationLogHandlerImpl implements OperationLogHandler {
    @Override
    public void handleOperationLog(OperationLog operationLog) {
        //日志打印在 //"${LOG_PATH}/${LOG_CONTEXT_NAME}${BUSINESS_DIR}" exam:\pedestal\logs\pedestal-ms-crawler\business\pedestal-ms-crawler.business.log
        BusinessLogger.getLogger().info(operationLog.printLog());
    }
}
