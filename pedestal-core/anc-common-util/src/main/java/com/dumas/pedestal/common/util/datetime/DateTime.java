package com.dumas.pedestal.common.util.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTime {
	public static final String PATTERN_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";

	/**
	 * 获取当前时间戳的字符串
	 * @return
	 */
	public static String getNowStr() {
		return String.valueOf(System.currentTimeMillis());
	}
	
	/**
	 * 日期格式化
	 * @param pattern format格式
	 * @param date  日期date
	 * @return
	 */
	public static String formatDateToStr(String pattern, Date date) {
		return getDateFormat(pattern).format(date);
	}

	/*
	 * Get date format by pattern.
	 */
	protected static DateFormat getDateFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	
	private static int getNextWeekDayPlus(Date gmtCreate, int nextWeekDay) {  
	    Calendar cd = Calendar.getInstance();  
	    cd.setTime(gmtCreate);  
	    // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......  
	    int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1  
	    if (dayOfWeek == nextWeekDay) {  
	        return 0;  
	    } else {  
	        return nextWeekDay - dayOfWeek;  
	    }  
	}  

	// 获得下周星期一的日期  
	public static Date getNextWeekDay(Date gmtCreate, int nextWeekDay) {  
	    int mondayPlus = getNextWeekDayPlus(gmtCreate, nextWeekDay);  
	    GregorianCalendar currentDate = new GregorianCalendar();  
	    currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);  
	    Date monday = currentDate.getTime();  
	    return monday;  
	}
	
}
