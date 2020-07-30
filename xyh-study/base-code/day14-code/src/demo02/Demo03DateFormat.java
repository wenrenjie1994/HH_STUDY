package demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.test.DateFormat类
作用：格式化（日期->文本）和解析（文本->日期）
1.成员方法：String format(Date date):按照指定的模式，把Date日期和石化为符合模式的字符串
2.成员方法：Date parse(String source):把符合模式的字符串，解析为Date日期
DateFormat类是一个抽象类，无法直接创建对象，可以使用DateFormat类的子类
已知子类SimpleDateFormat
构造方法：
SimpleDateFormat(String pattern)
用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat
参数：String pattern：传递指定的格式
区分大小写
y 年
M 月
d 日
H 时
m 分
s 秒
写对应的模式，会把模式替换为对应的日期和时间
模式的字母不可以替换，连接模式的符号可以改变
如：yyyy-MM-dd:HH:mm:ss
或 yyyy年MM日dd月HH时mm分ss秒
 */
public class Demo03DateFormat {
    public static void main(String[] args) throws ParseException {
      demo01();
      demo02();
    }

    private static void demo02() throws ParseException {
        /*使用DateFormate类中的方法parse，把文本解析为日期
        * 使用步骤：
        * 1.创建一个SimpleDateFormat对象
        * 2.调用SimpleDateFormat对象中的方法parse，把符合方法中模式的字符串，解析为Date日期
        * 注意：
        * public Date parse(String source) throws ParseException
        * parse 方法声明了一个移场叫做ParseException
        * 如果字符串和后遭方法的模式不一样，程序就会抛出异常
        * 调用一个抛出异常的方法，就必须处理异常，要么throws继续抛出这个异常，要么try catch 自己处理
        *
        */
        //1.创建一个SimpleDateFormat对象
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date date=sdf.parse("2020年07月30日21时06分00秒");
        System.out.println(date);

    }

    private static void demo01() {
        /*使用DateFormat类中的方法format，把日期格式化为文本*/
        //1.创建一个SimpleDateFormat对象
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        //2.调用SimpleDateFormat对象中的format
        Date date=new Date();
        System.out.println(date);
        System.out.println(sdf.format(date));
    }
}
