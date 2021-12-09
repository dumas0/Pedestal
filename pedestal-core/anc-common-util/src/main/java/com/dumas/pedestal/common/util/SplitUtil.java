package com.dumas.pedestal.common.util;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分割工具
 *
 * @author ygjy
 * @version V1.0
 * @since 2019-09-25 21:30
 */
public class SplitUtil {
    public static final String SPLIT_EQUAL = "=";
    public static final String SPLIT_AND = "&";
    public static final String SPLIT_COMMA = ",";

    public static String valueOfSplitByEqual(String data) {
        if (Objects.isNull(data)) {
            return null;
        }
        String[] dataArray = arrayOfSplitByEqual(data);
        if (Objects.nonNull(dataArray) && dataArray.length == 2) {
            return dataArray[1];
        } else {
            return null;
        }
    }

    public static String keyOfSplitByEqual(String data) {
        if (Objects.isNull(data)) {
            return null;
        }
        String[] dataArray = arrayOfSplitByEqual(data);
        if (Objects.nonNull(dataArray) && dataArray.length == 2) {
            return dataArray[0];
        } else {
            return null;
        }
    }

    public static String[] arrayOfSplitByEqual(String data) {
        if (Objects.isNull(data)) {
            return null;
        }
        return data.split(SPLIT_EQUAL);
    }

    /**
     * 将 逗号连接的 字符串转换成 指定的数据类型列表
     *  eg: {@code "1,2,3" => List<Integer>(1,2,3)}
     *
     * <pre>{@code
     *     String classIds = "111,222,333";
     *     SplitUtil.commaStr2List(classIds, (c) -> Integer.parseInt(c));
     * }</pre>
     *
     * @param commaStr
     * @param mapper
     * @param <R>
     * @return
     */
    public static <R> List<R> commaStr2List(String commaStr, Function<String, R> mapper) {
        return Stream.of(commaStr.split(SPLIT_COMMA))
            .map(mapper)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    /**
     * 将 逗号连接的 字符串转换成 字符串列表
     * eg: {@code "1,2,3" => List<String>("1","2","3")}
     *
     * @param commaStr
     * @return
     */
    public static List<String> commaStr2StrList(String commaStr) {
        return Stream.of(commaStr.split(SPLIT_COMMA)).collect(Collectors.toList());
    }
}
