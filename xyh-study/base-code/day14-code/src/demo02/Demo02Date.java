package demo02;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo();
        demo2();
        demo3();

    }

    public static  void demo(){
        /*Date类的空参数构造方法，Date()获取当前系统的日期和时间*/
        Date date=new Date();
        System.out.println(date);
    }
    public static  void demo2(){
        /*Date类的带参数的构造方法，Date(long date)传递毫秒值，把毫秒值转化为Date日期*/
        Date date=new Date(0L);
        System.out.println(date);

        Date date1=new Date(3742767540068L);
        System.out.println(date1);
    }

    public static  void demo3(){
        /*long getTime()把日期转化为毫秒值
        返回自1970年1月1日00：00：00GMT以来此Date对象的毫秒值，
        相当于System.currentTimeMillis()
        */
        Date date=new Date();
        long time= date.getTime();
        System.out.println(time);
    }
}
