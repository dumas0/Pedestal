package com.dumas.pedestal.framework.mongodb.util;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.regex.Pattern;

/**
 * @author dumas
 * @date 2021/12/06 2:55 PM
 */
public class MongoLikeUtil {
    public static Query allLike(Query query, String column, String likeParam) {
        return query.addCriteria(Criteria.where(column).regex(getAllFuzzy(likeParam)));
    }

    /**
     * 左模糊
     *
     * @param likeParam
     * @return
     */
    private static Pattern getLeftPattern(String likeParam) {
        return Pattern.compile("^.*" + likeParam + "$", Pattern.CASE_INSENSITIVE);
    }

    /**
     * 右模糊
     *
     * @param likeParam
     * @return
     */
    private static Pattern getRightPattern(String likeParam) {
        return Pattern.compile("^" + likeParam + ".*$", Pattern.CASE_INSENSITIVE);
    }

    /**
     * 精准匹配
     *
     * @param likeParam
     * @return
     */
    private static Pattern getExactPattern(String likeParam) {
        return Pattern.compile("^" + likeParam + "$", Pattern.CASE_INSENSITIVE);
    }

    /**
     * 全模糊
     *
     * @param likeParam
     * @return
     */
    private static Pattern getAllFuzzy(String likeParam) {
        return Pattern.compile("^.*" + likeParam + ".*$", Pattern.CASE_INSENSITIVE);
    }
}
