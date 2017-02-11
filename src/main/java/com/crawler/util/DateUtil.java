package com.crawler.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String UNIXDATE = "01/01/1970 00:00:00";
	
	public static Date getUnixDate(){
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			return sf.parse(UNIXDATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
