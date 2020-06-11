package Basic_Date.Date_Beginning; /**
 * @Author lee
 * @Date 2020/6/7 12:16 PM
 **/
import java.util.Date;

public class Exercise_how2j {
    public static void main(String[] args) {
        long second = 1000;
        long minute =  60*second;
        long hour = 60*minute;
        long day = 24*hour;
        long year = 365*day;
        long start = (1995-1970)*year;
        long leapYear=((1995-1970)/4)*day;
        start +=leapYear;

        Date startTime = new Date(start);
        System.out.println("1995年第一天："+startTime);

        long interval = year - 1 - 8*hour;
        long end = start + interval;

        Date endTime = new Date(end);
        System.out.println("1995年最后一天："+endTime);

        long random =(long)(Math.random()*interval)+start;
        Date randomTime = new Date(random);
        System.out.println("1995年这一年的随机时间："+randomTime);
    }
}
