package Basic_Date.Date_Beginning; /**
 * @Author lee
 * @Date 2020/6/7 10:54 AM
 **/

import java.util.*;
import java.text.*;
import java.util.Random;

public class Exercise_my {
    public static void main(String[] args) {

        Random random = new Random(1);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String start_time = "1995-1-1 00:00:00";
        String end_time = "1995-12-31 23:59:59";

        Date t;

        try {
            t = ft.parse(start_time);
            System.out.println("1995年的第一天：" + t);
            long start = t.getTime();
//          System.out.println(start);

            t = ft.parse(end_time);
            System.out.println("1995年的最后一天" + t);
            long end = t.getTime();

            long r = random.nextInt((int) (end - start)) + start;
            Date r_date = new Date(r);
            System.out.println("1995年这这一年中的随机一个时间：" + r_date);


        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }


    }


}

