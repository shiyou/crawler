package com.crawler.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	public static String yyyy_mm_dd = "YYYY-MM-DD"; 
	
	/**
	 * parse String as a date 
	 * @param s
	 * @param dateFormat
	 * @return
	 */
	public static Date parseDate(String s,String dateFormat){
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		Date date =null;
		try {
			date = sf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return DateUtil.getUnixDate();
		}
		return date;
	}
	
	

}
