package com.dumas.pedestal.common.model.exception;

/**
 * 第三方API异常处理类
 *
 * @author dumas
 * @date 2021/12/06 10:11 AM
 */
public class ThridPartApiServiceException extends ServiceException {
    public ThridPartApiServiceException() {
        super();
    }

    public ThridPartApiServiceException(String message) {
        super(message);
    }

    public ThridPartApiServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThridPartApiServiceException(Throwable cause) {
        super(cause);
    }

    public ThridPartApiServiceException(String url, String errorMsg) {
        super("ThirdPart api[" + url + "] invoke error:" + errorMsg);
    }
}
