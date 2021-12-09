package com.dumas.pedestal.common.util.datetime;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Date工具
 * 从 Date 转换成其他类型
 *
 * @author ygjy
 * @version V1.0
 * @since 2019-09-10 17:03
 */
public class DateUtil {
    /**
     * 北京时区
     */
    public static final ZoneId ZONEID_PEKING = ZoneId.of("GMT+08:00");

    /**
     * 日期转换格式
     */
    private static String[] PARSE_PATTERNS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
        "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
        "yyyy.MM.dd HH:mm", "yyyy.MM" };

    /**
     * 系统默认时区
     */
    public static final ZoneId ZONEID_DEFAULT = ZoneOffset.systemDefault();

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
     * yyyy-MM-dd HH:mm:ss.SSS 格式
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIME_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

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
     * HH:mm 格式
     */
    public static final DateTimeFormatter FORMATTER_TIME_HH_MM = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSS+08:00
     */
    public static final DateTimeFormatter FORMATTER_DATE_yyyyMMddTHHmmssSSS = DateTimeFormatter
        .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS+08:00");

    public static String getNowStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return FORMATTER_DATE_TIME.format(localDateTime);
    }

    public static String getDateTimeStr(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return FORMATTER_DATE_TIME.format(localDateTime);
    }

    public static LocalDateTime getLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * 去掉标准时间的间隔
     *
     * @return yyyyMMddHHmmss
     */
    public static String getNowWithoutSpace() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return FORMATTER_DATE_yyyyMMddHHmmss.format(localDateTime);
    }

    public static String getChinaTime(LocalDateTime time) {
        return FORMATTER_DATE_TIME_CHINESE.format(time);
    }

    public static String reshapTime(String sourceTime, DateTimeFormatter from, DateTimeFormatter to) {
        Objects.requireNonNull(sourceTime);
        return to.format(from.parse(sourceTime));
    }



    /**
     * 获取当前时间到1970-01-01T00:00:00Z的秒数
     *
     * @return
     */
    public static long getNowSeconds() {
        return LocalDateTime.now().atZone(ZONEID_DEFAULT).toEpochSecond();
    }

    /**
     * Date -> LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime ofLocalDateTime(Date date) {
        Objects.requireNonNull(date);
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZONEID_PEKING);
    }

    public static LocalDateTime fromStr(String yyyyMMddHHmmss) {
        LocalDateTime localTime = LocalDateTime.parse(yyyyMMddHHmmss, FORMATTER_DATE_TIME);
        return localTime;
    }

    public static LocalDate ofLocalDate(Date date) {
        Objects.requireNonNull(date);
        LocalDateTime localDateTime = ofLocalDateTime(date);
        return localDateTime.toLocalDate();
    }

    public static LocalTime ofLocalTime(Date date) {
        Objects.requireNonNull(date);

        LocalDateTime localDateTime = ofLocalDateTime(date);
        return localDateTime.toLocalTime();
    }

    /**
     * LocalDateTime -> Date
     *
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime);

        Instant instant = localDateTime.atZone(ZONEID_PEKING).toInstant();
        return Date.from(instant);
    }

    public static Date toDate(LocalDate localDate) {
        Objects.requireNonNull(localDate);
        return toDate(LocalDateTime.from(localDate));
    }

    /**
     * 适合 dateTime -> date
     * 不适合 time -> date
     * @param dateStr
     * @param formatter
     * @return
     */
    public static Date toDate(String dateStr, DateTimeFormatter formatter) {
        LocalDateTime localTime = LocalDateTime.parse(dateStr, formatter);
        return toDate(localTime);
    }

    public static Date toDate(LocalTime localTime) {
        Objects.requireNonNull(localTime);
        LocalDate localDate = LocalDate.of(1970,1,1);
        return toDate(LocalDateTime.of(localDate, localTime));
    }

    /**
     * str -> Date
     *
     * @param yyyyMMddHHmmss
     * @return
     */
    public static Date toDate(String yyyyMMddHHmmss) {
        LocalDateTime localTime = LocalDateTime.parse(yyyyMMddHHmmss, FORMATTER_DATE_TIME);
        return toDate(localTime);
    }

    /**
     * str -> LocalTime
     *
     * @param HHmmss
     * @return
     */
    public static LocalTime toLocalTime(String HHmmss) {
        LocalTime localTime = LocalTime.parse(HHmmss, FORMATTER_TIME);
        return localTime;
    }

    /**
     * 获取当前日期的星期
     * 1 ~ 7 分别为:星期一 ~ 星期天
     *
     * @param date
     * @return
     */
    public static DayOfWeek getDayOfWeek(Date date) {
        Objects.requireNonNull(date);

        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONEID_PEKING);
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        return dayOfWeek;
    }

    public static int getWeek(Date date) {
        Objects.requireNonNull(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = (week == 1 ? 7 : week - 1);
        return week;
    }

    public static void check(Date date) {
        LocalDateTime localTime = ofLocalDateTime(date);
        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
        LocalDateTime startYesterday = LocalDate.now().plusDays(-1).atTime(0, 0, 0);
        LocalDateTime endYesterday = LocalDate.now().plusDays(-1).atTime(23, 59, 59);

        //如果小于昨天的开始日期
        if (localTime.isBefore(startYesterday)) {
            System.out.println("时间是过去");
        }
        //时间是昨天
        if (localTime.isAfter(startYesterday) && localTime.isBefore(endYesterday)) {
            System.out.println("时间是昨天");
        }
        //如果大于今天的开始日期，小于今天的结束日期
        if (localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
            System.out.println("时间是今天");
        }
        //如果大于今天的结束日期
        if (localTime.isAfter(endTime)) {
            System.out.println("时间是未来");
        }
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(str.toString(), PARSE_PATTERNS);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * now - time = (?) seconds
     *
     * @param time
     * @return
     */
    public static long getDurationOfSeconds(Date time) {
        Duration duration = Duration.between(ofLocalDateTime(time), LocalDateTime.now());
        return duration.getSeconds();
    }

    private static long getDurationOfSeconds(Date startDate, Date endDate) {
        if (Objects.isNull(startDate)) {
            startDate = new Date();
        }
        if (Objects.isNull(endDate)) {
            endDate = new Date();
        }
        Duration duration = Duration.between(ofLocalDateTime(startDate), ofLocalDateTime(endDate));
        return duration.getSeconds();
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.parse("19:00");
        System.out.println(localTime);
        Date existedStartDate = DateUtil.toDate(localTime);
        System.out.println(DateFormatUtil.ofDateTime(existedStartDate));
    }

    /**
     * 获取两个时间的分钟差
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static Integer getIntervalMinute(Date beginTime, Date endTime){
        Long costTime = endTime.getTime() - beginTime.getTime();
        Double miniutes = Math.ceil(costTime / 1000.0d / 60);
        miniutes = miniutes < 0 ? 0:miniutes;
        return miniutes.intValue();
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date       日期
     * @param hourAmount 增加数量。可为负数
     * @return 增加分钟后的日期
     */
    public static Date addMinute(Date date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date      日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期
     */
    public static Date addDay(Date date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date     日期
     * @param dateType 类型
     * @param amount   数值
     * @return 计算后日期
     */
    public static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 计算时长
     *
     * @param settleTime
     * @param currentTime
     * @return
     */
    public static Integer getSettleTime(Date settleTime, long currentTime){
        Double miniutes = 0d;
        long costTime = currentTime - settleTime.getTime();
        costTime = costTime > 0 ? costTime : 0;
        miniutes = Math.ceil(costTime / 1000.0d / 60);
        return miniutes.intValue();
    }
}
