package Basic_Date.Date_Format;

/**
 * @Author lee
 * @Date 2020/6/7 7:53 PM
 **/

import java.util.Date;
import java.text.SimpleDateFormat;

public class Date2String {
    public static void main(String[] args) {

        Date now = new Date();
        System.out.println("当前时间：" + now);
//        System.out.println(now.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String format_now = sdf.format(now);
        System.out.println("当前时间通过格式 YYYY-MM-dd HH:mm:ss 后输出的时间：" + format_now);
    }
}
