**Date类笔记**  

----------


**一、毫秒值的概念和作用**   
1.java.util.Date类：表示特定的瞬间，精确到毫秒  
毫秒：千分之一秒 1000毫秒 = 1秒  
特定的瞬间：一个时间点  
2.毫秒值的作用：可以对时间和日期进行计算  
例如计算 2016-01-03 到 2020-08-08   一共有多少天：可以将日期转换为毫秒进行计算，计算完毕再把毫秒转换为日期  

把日期转换为毫秒就是计算当前日期到时间原点之间一共有多少毫秒：  
当前的日期：2020-08-08（System.currentTimeMillis()获取当前系统时间到时间原点经历的毫秒数）  
时间原点（0毫秒）：1970-01-01 00:00:00（英国格林威治标准时间）  

把毫秒转换为日期：  
1 天 = 24 × 60 × 60 = 86400 秒 = 86400 × 1000 = 86400000 毫秒  

注意：中国属于东八区，会把时间增加8个小时1970-01-01 08:00:00（英国格林威治标准时间）  

**二、Date类的构造方法和成员方法**  
1.构造方法：  

    Date()：获取当前系统的日期和时间
    System.out.println(new Date()); 输出 Mon Aug 03 14:12:19 CST 2020
    
    Date(long date)：传递毫秒值，把毫秒值转换为Date日期
    System.out.println(new Date(0L)); 输出 Thu Jan 01 08:00:00 CST 1970

2.成员方法：  

    long getTime()：返回自1970年1月1日以来，由此Date对象表示的00:00:00 GMT的毫秒数；
                    把日期转换为毫秒值，相当于System.currentTimeMillis()

**三、DateFormat类和SimpleDateFormat类**  
1.java.text.DateFormat是日期/时间格式化子类的抽象类（无法直接创建DateFormat的对象，可以使用DateFormat类的子类）  
作用：完成日期和文本之间的转换，也就是可以在Date对象与String对象之间进行来回转换  

    格式化：日期 -> 文本
    String format(Date date)：按照指定的格式，从Date对象转换为String对象
    解析：文本 -> 日期
    Date parse(String source)：按照指定的格式，从String对象转换为Date对象

2.java.text.SimpleDateFormat extends DateFormat  

    构造方法：
    SimpleDateFormat(String pattern)：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat
    参数：String pattern传递指定的模式
    模式：区分大小写的  y-年 / M-月 / d-日 / H-时 / m-分 / s-秒
    写对应的模式，会把模式替换为对应的日期和时间    yyyy-MM-dd HH:mm:ss
    注意：模式中的字母不能更改，连接模式的符号可以改变  yyyy年MM月dd日 HH时mm分ss秒

**四、DateFormat类的format方法和parse方法**  
1.format方法：把日期格式化为文本  

```java
public class DateDemo {
    public static void main(String[] args) {
        //1.创建SimpleDateFormat对象，构造方法中传递指定的模式
        SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //2.调用SimpleDateFormat对象中的方法format，按照构造方法中指定的模式，把Date日期格式化为符合模式的字符串（文本）
        System.out.println(simple.format(new Date()));
    }
}
```

输出：2020/08/03 14:48:23  

2.parse方法：把文本解析为Date日期  
注意：public Date parse(String source) throws ParseException  
parse方法声明了一个异常叫ParseException，如果字符串和构造方法的模式不一样，那么程序就会抛出此异常
调用一个抛出了异常的方法时，我们就必须处理这个异常，要么throws继续抛出这个异常，要么try...catch自己处理  

```java
public class DateDemo {
public static void main(String[] args) throws ParseException {
    //1.创建SimpleDateFormat对象，构造方法中传递指定的模式
    SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //2.调用SimpleDateFormat对象中的方法parse，把符合构造方法中模式的字符串解析为Date日期
    System.out.println(simple.parse("2020/08/03 14:50:14"));
}
```
}

输出：Mon Aug 03 14:50:14 CST 2020  