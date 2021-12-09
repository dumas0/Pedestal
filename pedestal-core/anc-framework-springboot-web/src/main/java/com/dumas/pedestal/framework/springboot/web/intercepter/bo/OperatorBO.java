package com.dumas.pedestal.framework.springboot.web.intercepter.bo;

import com.dumas.pedestal.framework.springboot.constant.enums.OperatorType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 操作人
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-19 20:24
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorBO {
    /**
     * 是否打印操作人信息
     */
    Boolean logOperator;
    /**
     * 操作人员类别
     * @return
     */
    OperatorType operatorType;

    /**
     * 操作人IP
     * @return
     */
    String operatorIp;

    /**
     * 操作人
     * @re */
    String operator;
}
