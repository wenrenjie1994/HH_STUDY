package SSM.UTILS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateToString(Date date,String patt){
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    public static Date stringToDate(String dateStr,String patt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        Date parse = dateFormat.parse(dateStr);
        return parse;
    }
}
