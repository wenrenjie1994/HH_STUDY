package com.pan.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-18 9:51
 */
public class DateTimeTest {

    @Test
    public void test() throws ParseException {
        String birth = "2020-09-08";
        //1.造一个对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //2.解析：字符串变成日期
        Date date = sdf.parse(birth);
        //3.将java.util.Date转换为java.sql.Date
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

}
