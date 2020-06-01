> 计算机都是"01"的天下，日期也需要转换为数字。1969年发布了第一个UNIX，将1970年作为时间原点

## 1 Data

> 创建时间对象，默认时间

```java
import java.util.Date;

//1970
public class Data_Test {

    public static void main(String[] args) {
        // 当前时间
        Date d1 = new Date();
        System.out.println("当前时间:");
        System.out.println(d1);
        System.out.println();
        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2);//Thu Jan 01 08:00:05 CST 1970
    }
}
```

## 2 getTime

>getTime将返回一个类似“Tue Jan 05 09:57:58 CST 2020

```java


//
import java.util.Date;

public class getTime_Demo {

    public static void main(String[] args) {
        //注意：是java.util.Date;
        //而非 java.sql.Date，此类是给数据库访问的时候使用的
        Date now= new Date();
        //打印当前时间
        System.out.println("当前时间:"+now.toString());
        //getTime() 得到一个long型的整数
        //这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
        System.out.println("当前时间getTime()返回的值是："+now.getTime());

        Date zero = new Date(0);
        System.out.println("用0作为构造方法，得到的日期是:"+zero);

    }
}
```

## 3 日期转字符串

> 使用SimpleData和format进行转换

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataToString {

    public static void main(String[] args) {

        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        Date d= new Date();
        String str = sdf.format(d);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);

        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
        Date d1= new Date();
        String str1 = sdf1.format(d1);
        System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: "+str1);

    }
}
```

## 4 字符串转日期

> 使用SimpleData和parse进行转换

```java
//
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String_To_Data {

    public static void main(String[] args) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );

        String str = "2020/5/31 10:12:12";

        try {
            Date d = sdf.parse(str);
            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s",str,d.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
```

## 5 Calender类

> Calender为抽象类，可以方便的设置和获取日期数据的特定部分。它还有个已知的子类GregorianCalendar。
> Calendar中的静态常量（常用的）：

| 常量                   | 描述                                    |
| ---------------------- | --------------------------------------- |
| Calendar.AM            | 从午夜到中午之前这段时间的 AM_PM 字段值 |
| Calendar.PM            | 从中午到午夜之前这段时间的 AM_PM 字段值 |
| Calendar.YEAR          | 年份                                    |
| Calendar.MONTH         | 月份                                    |
| Calendar.DATE          | 日期                                    |
| Calendar.HOUR          | 小时(12小时制)                          |
| Calendar.MINUTE        | 分钟                                    |
| Calendar.SECOND        | 秒                                      |
| Calendar.WEEK_OF_YEAR  | 年内的某星期                            |
| Calendar.WEEK_OF_MONTH | 月内的某星期                            |
| Calendar.DAY_OF_YEAR   | 年内的某天                              |
| Calendar.DAY_OF_MONTH  | 月内的某天                              |
| Calendar.DAY_OF_WEEK   | 星期内的某天(从周日开始计算)            |
| Calendar.HOUR_OF_DAY   | 小时(24小时制)                          |

```
import java.util.Calendar;
import java.util.TimeZone;

public class Calender_Test {
    public static  void main(String[] args){
        Calendar c = Calendar.getInstance(); // 获取当前时间的日历对象
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00")); //获取东八区的日历实例对象

        System.out.println(c.get(Calendar.YEAR));   // 2020 年份
        System.out.println(c.get(Calendar.MONTH)+1);// 5  月份,需要+1
        System.out.println(c.get(Calendar.DATE));   // 31 日期
        System.out.println(c.get(Calendar.AM_PM));  // 1  AM=0， PM=1
        System.out.println(c.get(Calendar.HOUR));   // 3 小时
        System.out.println(c.get(Calendar.MINUTE)); // 18 分钟
        System.out.println(c.get(Calendar.SECOND)); // 10 秒
        System.out.println(c.get(Calendar.MILLISECOND)); // 973  毫秒

//--------------------------------------------------------------------------

        System.out.println(c.toString()); // 返回此日历的字符串表示形式
        System.out.println(c.getTime()); // 返回一个Date类型的时间
        System.out.println(c.getTimeInMillis()); // 返回当前时间的毫秒数
        System.out.println(c.getTimeZone().getDisplayName()); // 中国标准时间  默认区域的用户的时区名称
        System.out.println(c.getTimeZone().getID()); // Asia/Shanghai 返回时区ID
        System.out.println(c.getMaximum(Calendar.HOUR)); // 11 返回小时中最大的数
    }
}

```

## 6 SimpleDateFormat类(java.text.SimpleDateFormat)

> SimpleDateFormat继承抽象类 DateFormat。 是一个以与语言环境有关的方式来格式化和解析日期的具体类，且**非线程安全**。它允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。使得可以选择任何用户定义的日期-时间格式的模式。
> 日期和时间的格式化编码：

| 字母 | 描述            | 表示              | 示例                    |
| ---- | --------------- | ----------------- | ----------------------- |
| y    | 年份            | Year              | 2020                    |
| M    | 月份            | Month             | July; Jul; 07           |
| d    | 月内的日期      | Number            | 10                      |
| h    | 12小时制(1~12)  | Number            | 10                      |
| H    | 24小时制 (0~23) | Number            | 20                      |
| m    | 分钟数          | Number            | 30                      |
| s    | 秒数            | Number            | 48                      |
| S    | 毫秒数          | Number            | 227                     |
| E    | 星期几          | Text              | Tuesday                 |
| D    | 年内的天数      | Number            | 180                     |
| F    | 月内的星期      | Number            | 2 (second Wed. in July) |
| w    | 年内的周数      | Number            | 40                      |
| W    | 月内的周数      | Number            | 1                       |
| a    | AM/PM 标记      | Text              | PM                      |
| k    | 24小时制(1~24)  | Number            | 24                      |
| K    | 12小时制(0~11)  | Number            | 10                      |
| z    | 时区            | General time zone | Eastern Standard Time   |

## 7 总结

> 今日分享学习时间处理相关函数和字符串的交换。

persist