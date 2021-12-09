package com.dumas.pedestal.common.model.exception;

/**
 * 业务处理异常类
 *
 * @author dumas
 * @date 2021/12/06 10:07 AM
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
