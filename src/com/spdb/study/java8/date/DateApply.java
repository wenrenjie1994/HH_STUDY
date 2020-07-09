package com.spdb.study.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Java 8中Date部分API
 * @author Mr.Longyx
 * @date 2020年07月09日 18:45
 */
public class DateApply {
    public static void main(String[] args) {
        testLocalDate();
        testLocalTime();
        testCombineLocalDateAndTime();
        testInstant();
        testDuration();
        testPeriod();
        testDateFormat();
        testDateParse();
    }
    private static void testLocalDate(){
        LocalDate localDate = LocalDate.of(2020, 6, 30);
        System.out.println(localDate.getYear()+" "+localDate.getMonth()+" "+localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth()+" "+localDate.getDayOfWeek());
        System.out.println(localDate.getMonthValue());

    }
    private static void testLocalTime(){
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour()+" "+time.getMinute()+" "+time.getSecond());
    }

    private static void testCombineLocalDateAndTime(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.toString());
        System.out.println(LocalDateTime.now());

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }

    private static void testInstant(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(now,end);
        System.out.println(duration.toMillis());
    }

    private static void testDuration(){
        LocalTime start = LocalTime.now();
        LocalTime localTime = start.minusHours(1);
        Duration duration = Duration.between(localTime, start);
        long hours = duration.toHours();
        System.out.println(hours);
    }

    private static void testPeriod(){
        Period between = Period.between(LocalDate.of(2015, 2, 28), LocalDate.of(2020, 10, 8));
        System.out.println(between.getMonths());
    }

    private static void testDateFormat(){
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String fm = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String format1 = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(format);
        System.out.println(fm);
        System.out.println(format1);
    }

    private static void testDateParse(){
        String date = "20191219";
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1 = "2019/11/28";
        LocalDate localDate = LocalDate.parse(date1, dateTimeFormatter);
        System.out.println(localDate);
    }
}
