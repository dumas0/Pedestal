package com.dumas.pedestal.common.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * create by shibo on 2018/7/23
 **/
public class NullUtils {

    /**
     * 获取非空值
     *
     * @param value
     * @return
     */
    public static String getNotNullValue(String value) {
        return null == value ? "" : value;
    }

    /**
     * 获取非空值
     *
     * @param value
     * @return
     */
    public static Integer getNotNullValue(Integer value) {
        return null == value ? 0 : value;
    }

    public static Double getNotNullValue(Double value) {
        return null == value ? 0 : value;
    }

    public static long getNotNullValue(Long value) {
        return null == value ? 0L : value;
    }

    public static Boolean getNotNullValue(Boolean value) {
        return null == value ? false : value;
    }

    public static int getNotNullValue(LocalDateTime value) {
        return null == value ? 0 : (int)value.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    public static double getNotNullValue(BigDecimal value) {
        return null == value ? 0.0 : value.doubleValue();
    }

}
