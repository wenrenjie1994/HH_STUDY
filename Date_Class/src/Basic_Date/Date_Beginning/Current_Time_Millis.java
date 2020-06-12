package Basic_Date.Date_Beginning; /**
 * @Author lee
 * @Date 2020/6/7 10:51 AM
 **/
import java.util.Date;

public class Current_Time_Millis {
    public static void main(String[] args) {
        Date now = new Date();

        System.out.println("Date.getTime()\t\t\t\t返回值："+now.getTime());
        System.out.println("System.currentTimeMillis()\t返回值："+System.currentTimeMillis());

    }
}
