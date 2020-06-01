//
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String_To_Data {

    public static void main(String[] args) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );

        String str = "2020/5/31 10:12:12";

        try {
            Date d = sdf.parse(str);
            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s",str,d.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
