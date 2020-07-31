package demo03;

import java.util.Calendar;

/*
* java.util.Calendar是抽象类
* 里面提供了很多操作日历字段的方法（YEAR MONTH DAY_OF_MONTH HOUR）
* Calendar类无法直接创建对象使用，里面有一个静态方法叫getInstance(),该方法返回了该类的子类对象
*
* */
public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        System.out.println(c);
    }
}
