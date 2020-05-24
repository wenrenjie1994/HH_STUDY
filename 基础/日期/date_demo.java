import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author hua.xiao
 * @date 2020/5/24
 */
public class DATE_DEMO {
    public static void main(String[] args) {
        Date d1=new Date();
        System.out.println("当前时间：");
        System.out.println(d1);
        System.out.println();
        Date d2=new Date();
        Calendar ca=new GregorianCalendar();
        System.out.println("YEAR:"+ca.get(Calendar.YEAR));
        System.out.println("MONTH:"+ca);
        System.out.println("DAY:"+ca.get(Calendar.DATE));
        System.out.println("HOUR:"+ca.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE:"+ca.get(Calendar.MINUTE));
        System.out.println("SECOND:"+ca.get(Calendar.SECOND));
        //////////////////格式化数据//////////////////////
        DateFormat df1=DateFormat.getDateInstance();
        DateFormat df2=DateFormat.getDateTimeInstance();
        System.out.println("DATE"+df1.format(new Date()));
        System.out.println("DATETIME"+df2.format(new Date()));

        String strDate ="2018-10-19 10:30:14.345";
        String sp1="YYYY-MM-DD HH:mm:ss.SSS";
        SimpleDateFormat spf1=new SimpleDateFormat(sp1);
        SimpleDateFormat spf2=new SimpleDateFormat();

        Date dt=null;
        try {
            dt=spf1.parse(strDate);
        }catch (Exception e){
            e.printStackTrace();
        }
       System.out.println(dt);
    }


}

