package demo03;

import java.util.Calendar;
import java.util.Date;

/*
* Calendar类的常见成员方法：
* 1.public int get(int field):返回给定日历字段的值
* 2.pubic void set (int field,int value):将给定的日历字段设置为给定值
* 3.public abstract void add(int field,int amount):根据日历规则，为给定的日历字段添加或减去指定的时间量
* 4.public Date getTime():返回一个表示此Calendar时间值（从历元到现在的毫秒偏移值）的Date对象
* 成员方法参数：
* int field：日历类的字段，可以使用Calander类的静态成员变量获取
* public static final int YEAR=1; 年
* public static final int MONTH=2; 月
* public static final int DATE=5; 月中的某一天
* public static final int DAY_OF_MONTH=5; 月中的某一天
* public static final int HOUR=10; 时
* public static final int MINUTE=12; 分
* public static final int SECOND=13; 秒
*
* */
public class Demo02Calendar {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    private static void demo04() {
        /*public Date getTime():返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象
        * 实际就是把日历对象转化为日期对象
        * */
        //获取Calendar对象
        Calendar calendar=Calendar.getInstance();
        Date time=calendar.getTime();
        System.out.println(time);
    }

    private static void demo03() {
        /*
        * public abstract void add(int field,int amount)：
        * 根据日历的规则，为给定的日历字段添加或减去指定的时间量
        * 参数：
        * int field：传递指定的日历字段
        * int amount：增加减少指定的值
        * 正数：增加
        * 负数：减少
        * */
        //获取Calendar对象
        Calendar calendar=Calendar.getInstance();
        //int year= calendar.get(1);
        //把年增加2年,把月减少2月
        calendar.add(Calendar.YEAR,2);
        calendar.add(Calendar.MONTH,-2);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH)+1);//西方月份0-11，东方月份1-12

    }

    private static void demo02() {
        /*
        * public void set(int field ,int value):将给定的日历字段设置为给定值
        * 参数：
        * int field：传递指定的日历字段
        * int value：给指定字段设置值
        * */
        //获取Calendar对象
        Calendar calendar=Calendar.getInstance();
        //一、设置年为9999年9月9日
        calendar.set(Calendar.YEAR,9999);
        calendar.set(Calendar.MONTH,9);
        calendar.set(Calendar.DATE,9);
        //二、也可以同时设置年月日,方法的重载
        calendar.set(9999,9,9);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
    }

    private static void demo01() {
        //获取Calendar对象
        Calendar calendar=Calendar.getInstance();
        //int year= calendar.get(1);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH)+1);//西方月份0-11，东方月份1-12
        System.out.println(calendar.get(Calendar.DATE));
    }
}
