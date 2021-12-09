package com.dumas.pedestal.common.util.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * 日期格式化工具类
 *
 * @author andaren
 * @version V1.0
 * @since 2020-08-21 16:58
 */
public class DateFormatUtil {
    /**
     * 北京时区
     */
    private static final ZoneId ZONEID_PEKING = ZoneId.of("GMT+08:00");

    /**
     * 汉字模式
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIME_CHINESE = DateTimeFormatter
        .ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

    /**
     * yyyyMMdd 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE_yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * yyyyMMddHHmmss 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE_yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * yyyy-MM-dd 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * HH:mm:ss 格式
     */
    public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * yyyy-MM-dd HH:mm:ss.SSS 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIME_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * HH:mm 格式
     */
    public static final DateTimeFormatter FORMATTER_TIME_HH_MM = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSS+08:00
     */
    public static final DateTimeFormatter FORMATTER_DATE_yyyyMMddTHHmmssSSS = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS+08:00");

    /**
     * {@code Date => String(yyyy-MM-dd HH:mm:ss)}
     * @param date
     * @return
     */
    public static String ofDateTime(Date date) {
        Objects.requireNonNull(date);
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZONEID_PEKING).format(FORMATTER_DATE_TIME);
    }

    /**
     * {@code LocalDateTime => String(yyyy-MM-dd HH:mm:ss)}
     * @param date
     * @return
     */
    public static String ofDateTime(LocalDateTime date) {
        Objects.requireNonNull(date);
        return date.format(FORMATTER_DATE_TIME);
    }

    /**
     * {@code Date => String(yyyy-MM-dd)}
     * @param date
     * @return
     */
    public static String ofDate(Date date) {
        Objects.requireNonNull(date);
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZONEID_PEKING).toLocalDate().format(FORMATTER_DATE);
    }

    /**
     * {@code LocalDate => String(yyyy-MM-dd)}
     * @param date
     * @return
     */
    public static String ofDate(LocalDate date) {
        Objects.requireNonNull(date);
        return date.format(FORMATTER_DATE);
    }

    /**
     * {@code Date => String(HH:mm:ss)}
     * @param date
     * @return
     */
    public static String ofTime(Date date) {
        Objects.requireNonNull(date);
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZONEID_PEKING).toLocalTime().format(FORMATTER_TIME);
    }

    /**
     * {@code LocalTime => String(HH:mm:ss)}
     * @param date
     * @return
     */
    public static String ofTime(LocalTime date) {
        Objects.requireNonNull(date);
        return date.format(FORMATTER_TIME);
    }

    public static String getTodayStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return FORMATTER_DATE_yyyyMMdd.format(localDateTime);
    }

    /**
     * {@code Date => String(HH:mm)}
     * @param date
     * @return
     */
    public static String ofMiniTime(Date date) {
        Objects.requireNonNull(date);
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZONEID_PEKING).toLocalTime().format(FORMATTER_TIME_HH_MM);
    }

    public static void main(String[] args) {
        System.out.println(ofMiniTime(new Date()));
    }
}
