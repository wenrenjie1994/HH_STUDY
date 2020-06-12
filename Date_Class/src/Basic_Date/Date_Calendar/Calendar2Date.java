package Basic_Date.Date_Calendar;

/**
 * @Author lee
 * @Date 2020/6/9 10:50 AM
 **/
import java.util.Date;
import java.util.Calendar;

public class Calendar2Date {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        Date d = c.getTime();
        Date d2 = new Date(0);
        c.setTime(d2);
    }
}
