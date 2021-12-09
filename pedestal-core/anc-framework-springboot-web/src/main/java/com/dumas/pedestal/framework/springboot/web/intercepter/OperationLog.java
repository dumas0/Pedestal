package com.dumas.pedestal.framework.springboot.web.intercepter;

import com.dumas.pedestal.common.util.datetime.DateUtil;
import com.dumas.pedestal.framework.springboot.constant.enums.BusinessType;
import com.dumas.pedestal.framework.springboot.web.annotation.Log;
import com.dumas.pedestal.framework.springboot.web.intercepter.bo.MethodBO;
import com.dumas.pedestal.framework.springboot.web.intercepter.bo.OperatorBO;
import com.dumas.pedestal.framework.springboot.web.intercepter.bo.RequestBO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 操作日志
 *
 * @author andaren
 * @version V1.0
 * @since 2020-11-19 20:20
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationLog {
    /**
     * 应用
     * @return
     */
    String app;

    /**
     * 模块
     * @return
     */
    String module;

    /**
     * 业务类型
     */
    BusinessType bizType;

    /**
     * 描述
     * @return
     */
    String description;

    /**
     * 请求信息
     */
    RequestBO requestInfo;

    /**
     * 操作人员信息
     */
    OperatorBO operatorInfo;

    /**
     * 调用的方法信息
     */
    MethodBO methodInfo;

    private OperationLog() {

    }

    public static OperationLog ofNew(Log logAnnotation) {
        OperationLog newLog = new OperationLog();
        newLog.setRequestInfo(new RequestBO());
        newLog.getRequestInfo().setLogReq(logAnnotation.logReq());
        newLog.setMethodInfo(new MethodBO());
        newLog.getMethodInfo().setLogMethod(logAnnotation.logMethod());
        newLog.setOperatorInfo(new OperatorBO());
        newLog.getOperatorInfo().setLogOperator(logAnnotation.logOperator());
        newLog.getOperatorInfo().setOperatorType(logAnnotation.operatorType());

        newLog.setModule(logAnnotation.module());
        newLog.setBizType(logAnnotation.bizType());
        newLog.setDescription(logAnnotation.description());
        return newLog;
    }

    public String printLog() {
        StringBuilder logSb = new StringBuilder();
        logSb.append("[").append(DateUtil.FORMATTER_DATE_TIME_SSS.format(LocalDateTime.now())).append("-").append(LocalTime.now().getNano()).append("]----------------------------------------------------\n")
            .append("[").append(app).append("]").append("-[").append(module).append("]-")
            .append("[").append(bizType.name()).append("]: ").append(description).append("\n");
        if (requestInfo.getLogReq()) {
            logSb
                .append("Req      :[").append(requestInfo.getHttpMethod()).append("]").append(requestInfo.getReqUri()).append("\n");
        }
        if (methodInfo.getLogMethod()) {
            logSb
                .append("Method   :[").append(methodInfo.getClassName()).append(".")
                .append(methodInfo.getMethodName()).append("] execute ").append(methodInfo.isHadExp()?"[fail]":"[ok]").append("\n")
                .append("       -> param=").append(methodInfo.getParam()).append("\n");
            if (methodInfo.isHadExp()) {
                logSb
                .append("       -> exp=").append(methodInfo.getExpMsg()).append("\n");
            } else {
                logSb
                .append("       -> result=").append(methodInfo.getResult()).append("\n");
            }
        }

        if (operatorInfo.getLogOperator()) {
            logSb
                .append("Operator :[").append(operatorInfo.getOperatorType().name()).append("-")
                .append(operatorInfo.getOperatorIp()).append("]").append(operatorInfo.getOperator()).append("\n");
        }
        return logSb.toString();
    }
}
