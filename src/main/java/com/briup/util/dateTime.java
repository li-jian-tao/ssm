package com.briup.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTime {
	public Timestamp NowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		Timestamp timesdate = null;
		try {
			Date nowDate = df.parse(date);
			timesdate = new java.sql.Timestamp(nowDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timesdate;
	}
}
