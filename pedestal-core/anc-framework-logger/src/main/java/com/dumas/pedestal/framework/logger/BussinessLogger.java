package com.dumas.pedestal.framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 业务日志
 *
 * @author dumas
 * @date 2021/12/06 2:01 PM
 */
public class BussinessLogger {
    private static Logger BUSSINESS_LOGGER = LoggerFactory.getLogger(BussinessLogger.class);

    private static Logger getLogger() {
        return BUSSINESS_LOGGER;
    }
}
