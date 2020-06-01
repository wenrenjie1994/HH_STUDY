import java.util.Calendar;
import java.util.TimeZone;

public class Calender_Test {
    public static  void main(String[] args){
        Calendar c = Calendar.getInstance(); // 获取当前时间的日历对象
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00")); //获取东八区的日历实例对象

        System.out.println(c.get(Calendar.YEAR));   // 2020 年份
        System.out.println(c.get(Calendar.MONTH)+1);// 5  月份,需要+1
        System.out.println(c.get(Calendar.DATE));   // 31 日期
        System.out.println(c.get(Calendar.AM_PM));  // 1  AM=0， PM=1
        System.out.println(c.get(Calendar.HOUR));   // 3 小时
        System.out.println(c.get(Calendar.MINUTE)); // 18 分钟
        System.out.println(c.get(Calendar.SECOND)); // 10 秒
        System.out.println(c.get(Calendar.MILLISECOND)); // 973  毫秒

//--------------------------------------------------------------------------

        System.out.println(c.toString()); // 返回此日历的字符串表示形式
        System.out.println(c.getTime()); // 返回一个Date类型的时间
        System.out.println(c.getTimeInMillis()); // 返回当前时间的毫秒数
        System.out.println(c.getTimeZone().getDisplayName()); // 中国标准时间  默认区域的用户的时区名称
        System.out.println(c.getTimeZone().getID()); // Asia/Shanghai 返回时区ID
        System.out.println(c.getMaximum(Calendar.HOUR)); // 11 返回小时中最大的数
    }
}
