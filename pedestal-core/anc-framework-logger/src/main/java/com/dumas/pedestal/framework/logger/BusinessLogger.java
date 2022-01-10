package com.dumas.pedestal.framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 业务日志
 *
 * @author dumas
 * @date 2021/12/06 2:01 PM
 */
public class BusinessLogger {
    private static Logger BUSINESS_LOGGER = LoggerFactory.getLogger(BusinessLogger.class);

    public static Logger getLogger() {
        return BUSINESS_LOGGER;
    }
}
