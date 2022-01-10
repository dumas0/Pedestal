package com.dumas.pedestal.framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件日志
 *
 * @author dumas
 * @date 2021/12/06 2:03 PM
 */
public class EventLogger {
    private static Logger EVENT_LOGGER = LoggerFactory.getLogger(EventLogger.class);

    public static Logger getLogger() {
        return EVENT_LOGGER;
    }
}
