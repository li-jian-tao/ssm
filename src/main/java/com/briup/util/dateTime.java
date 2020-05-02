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
	
	public String ChangeDate(Timestamp date) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		String[] split = time.split("[\\s-:]+");
		return split[0]+"年"+split[1]+"月"+split[2]+"日";
	}
}
