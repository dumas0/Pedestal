package com.dumas.pedestal.common.model.constant.enums;

/**
 * 逻辑状态
 *
 * @author dumas
 * @date 2021/12/06 10:07 AM
 */
public enum LogicalStatusEnum {
    /**
     * 启用状态
     */
    ENABLE(0),
    DISABLED(1),

    /**
     * 是否删除了
     */
    UNDELETE(0),
    DELETED(1),
    ;
    private Integer code;

    LogicalStatusEnum(Integer code) {
        this.code = code;
    }

    public static LogicalStatusEnum getByCode(Integer code) {
        for (LogicalStatusEnum e : LogicalStatusEnum.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public Integer code() {
        return code;
    }

    /**
     * 校验是否满足指定逻辑
     * @param code
     * @return
     */
    public boolean check(Integer code) {
        return this.code.equals(code);
    }
}