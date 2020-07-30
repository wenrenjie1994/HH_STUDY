package demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*练习：请使用日期相关的API，计算出一个人已经出生多少天
思路
1.获取当前时间对应的毫秒值
2.获取自己出生日期对应的毫秒值
3.两个时间相减（当前时间-出生日期）
分析：
1.使用Scanner类中的方法next，获取出生日期
2.使用DateFormat类中的方法parse，把字符串的出生日期解析成Date格式
3.把Date格式的出生日期转化为毫秒值
4.获取当前的日期，转化为毫秒值
5.使用当前日期的毫秒值-出生日期的毫秒值
6.把毫秒值的差值转化为天（s/1000/60/60/24）
*/
public class Demo04Ecercise {
    public static void main(String[] args) throws ParseException {
        //1.使用Scanner类中的方法next，获取出生日期
        System.out.println("请输入出生年月日，格式为yyyy-MM-dd");
        Scanner sc=new Scanner(System.in);
        String birthdayDateString=sc.next();
        //2.使用DateFormat类中的方法parse，把字符串的出生日期解析成Date格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate=simpleDateFormat.parse(birthdayDateString);
        //3.把Date格式的出生日期转化为毫秒值
        long birthdayTime=birthdayDate.getTime();
        //4.获取当前的日期，转化为毫秒值
        long todayTime=new Date().getTime();
        //5.使用当前日期的毫秒值-出生日期的毫秒值
        long time=todayTime-birthdayTime;
        //6.把毫秒值的差值转化为天（s/1000/60/60/24）
        System.out.println(time/1000/60/60/24);

    }
}
