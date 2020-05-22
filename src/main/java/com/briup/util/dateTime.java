package com.briup.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateTime {
	public static Timestamp NowDate() {
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
	
	public static String ChangeDate(Timestamp date) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		String[] split = time.split("[\\s-:]+");
		return split[0]+"年"+split[1]+"月"+split[2]+"日";
	}
	
	public static String ChangeMonth(int i) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -i);
		Date time = calendar.getTime();
		return df.format(time);
	}
	
	public static boolean setTime(Timestamp historydate,String date,String nextdate) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Date startTime = ft.parse(date+"-01 00:00:00");
		Date endTime = ft.parse(nextdate+"-01 00:00:00");
		//Date nowTime = new Date();
		boolean effectiveDate = isEffectiveDate(historydate, startTime, endTime);
		return effectiveDate;
	}	
	
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
	
}
