package utils;

import java.util.Calendar;

public class Time {
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getNow(){
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}
	
	public static int getAge(String birthday){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR)-Integer.parseInt(birthday.split("-")[0]);
	}
}
