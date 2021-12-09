package com.dumas.pedestal.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author andaren
 * @version V1.0
 * @since 2020-05-10 11:28
 */
public class JacksonUtil {
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //修改日期格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 对象转为字符串
     *
     * @param obj
     * @return
     */
    public static String Object2Json(Object obj) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 对象转为byte数组
     *
     * @param obj
     * @return
     */
    public static byte[] object2ByteArray(Object obj) {
        byte[] byteArr = new byte[0];
        try {
            byteArr = mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return byteArr;
    }

    /**
     * json字符串转为对象
     *
     * @param jsonStr
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String jsonStr, Class<T> beanType) {
        T t = null;
        try {
            t = mapper.readValue(jsonStr, beanType);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return t;
    }

    /**
     * byte数组转为对象
     *
     * @param byteArr
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T byteArr2Object(byte[] byteArr, Class<T> beanType) {
        T t = null;
        try {
            t = mapper.readValue(byteArr, beanType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 集合转为字符串
     *
     * @param list
     * @return
     */
    public static String list2String(List list) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 字符串转集合
     *
     * @param jsonStr
     * @return
     */
    public static List json2List(String jsonStr) {
        List list = null;
        try {
            list = mapper.readValue(jsonStr, List.class);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    /**
     * Map转为字符串
     *
     * @param map
     * @return
     */
    public static String map2String(Map map) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 字符串转Map
     *
     * @param jsonStr
     * @return
     */
    public static Map json2Map(String jsonStr) {
        Map map = null;
        try {
            map = mapper.readValue(jsonStr, Map.class);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return map;
    }


}
