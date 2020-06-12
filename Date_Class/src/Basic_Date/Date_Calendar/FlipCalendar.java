package Basic_Date.Date_Calendar;

/**
 * @Author lee
 * @Date 2020/6/9 10:54 AM
 **/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class FlipCalendar {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static String format(Date time) {
        return sdf.format(time);
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();

        System.out.println("当前日期：\t" + format(c.getTime()));

        c.setTime(now);
        c.add(Calendar.MONTH,1);
        System.out.println("下个月的今天：\t" + format(c.getTime()));

        c.setTime(now);
        c.add(Calendar.YEAR,-1);
        System.out.println("去年的今天：\t" + format(c.getTime()));

        c.setTime(now);
        c.add(Calendar.MONTH,-1);
        c.set(Calendar.DATE,3);
        System.out.println("上个月的第三天：\t" + format(c.getTime()));

    }
}
