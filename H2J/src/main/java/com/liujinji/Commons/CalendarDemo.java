package com.liujinji.Commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarDemo {
    public static void main(String[] args) {

        // 日期格式化
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String dateString = df.format(new Date());
        System.out.println(dateString);

        // 创建Calendar对象
        Calendar calendar = Calendar.getInstance();

        // 在必要的时候可以传入Date对象重新设置时间
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// 获得日期
        System.out.println(calendar.get(Calendar.MONTH));// 获得月份
        calendar.add(Calendar.HOUR_OF_DAY, 5);// 修改时间
        System.out.println("5小时后的时间：" + calendar.getTime());
        // 时区
        TimeZone tz0 = TimeZone.getTimeZone("PST"); // PST: 太平洋时区ID
        TimeZone tz1 = TimeZone.getDefault(); // 获取主机所处时区
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayCountry());
    }
}
