package com.dumas.pedestal.framework.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.core.pattern.CompositeConverter;

import java.net.InetAddress;

/**
 * 主机日志
 *
 * @author dumas
 * @date 2021/12/06 2:05 PM
 */
public class HostLogConfig extends CompositeConverter<ILoggingEvent> {

    private static final Logger logger = LoggerFactory.getLogger(HostLogConfig.class);

    @Override
    protected String transform(ILoggingEvent iLoggingEvent, String s) {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "DEFAULT";
    }
}
