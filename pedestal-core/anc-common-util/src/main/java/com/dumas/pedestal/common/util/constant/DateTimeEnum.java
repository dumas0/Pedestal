package com.dumas.pedestal.common.util.constant;

import com.dumas.pedestal.common.util.datetime.DateFormatUtil;
import com.dumas.pedestal.common.util.datetime.DateUtil;

import java.util.Date;

public enum DateTimeEnum {

	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");
	private String formateStr;
	DateTimeEnum(String formateStr) {
		this.formateStr = formateStr;
	}

	public String toStr(Date date) {
		return DateFormatUtil.ofDateTime(date);
	}
	public Date toDate(String dateStr) {
		return DateUtil.toDate(dateStr);
	}
	
}
