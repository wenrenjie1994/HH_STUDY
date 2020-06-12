package Basic_Date.Date_Calendar;

/**
 * @Author lee
 * @Date 2020/6/9 11:07 AM
 **/

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Exercise_my {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date time) {
        return sdf.format(time);
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();

        System.out.println("当前日期：\t\t\t" + format(cal.getTime()));

        cal.setTime(now);
        cal.add(Calendar.MONTH, 2);
        cal.set(Calendar.DATE,-2);
        System.out.println("下个月的倒数第三天：\t" + format(cal.getTime()));
    }
}
