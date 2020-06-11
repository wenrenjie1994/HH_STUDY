package Basic_Date.Date_Format;

/**
 * @Author lee
 * @Date 2020/6/7 7:59 PM
 **/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2Date {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

        String date_string = "2020/06/07 19:30:20";

        Date d;

        try {
            d = sdf.parse(date_string);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
