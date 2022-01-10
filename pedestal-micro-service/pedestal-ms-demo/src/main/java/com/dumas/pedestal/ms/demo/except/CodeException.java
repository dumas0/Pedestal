package com.dumas.pedestal.ms.demo.except;

import com.dumas.pedestal.common.model.inf.ResponseCode;
import lombok.Data;

/**
 * 异常处理
 * @author dumas
 * @date 2022/01/10 2:17 PM
 */
@Data
public class CodeException extends RuntimeException {
    private ResponseCode code;

    public CodeException() {
    }

    public CodeException(ResponseCode code) {
        this.code = code;
    }
}
