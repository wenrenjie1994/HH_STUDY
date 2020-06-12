package Basic_Date.Date_Format;

/**
 * @Author lee
 * @Date 2020/6/7 8:07 PM
 **/

import java.util.Date;
import java.text.SimpleDateFormat;

public class Exercise_my {

    public Date createRamdomDate() {
        long second = 1000;
        long minute = 60 * second;
        long hour = 60 * minute;
        long day = 24 * hour;
        long year = 365 * day;
        long interval = (2000 - 1970) * year;
        long leapYear = ((2000 - 1970) / 4) * day ;
        interval += leapYear;

        interval  =interval -8*hour + year + day -1;



        Date endTime = new Date(interval);
//        System.out.println("1995年最后一天：" + endTime);

        long random = (long) (Math.random() * interval) ;
        Date randomTime = new Date(random);
//        System.out.println("1995年这一年的随机时间：" + randomTime);

        return randomTime;
    }

    public static String toString(Date d){
        return toString(d, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toString(Date d, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    public static void main(String[] args) {

        Exercise_my my_date = new Exercise_my();
        int array_size = 9;
        Date[] date_array = new Date[array_size];
        for(int i=0; i<date_array.length;i++){
            Date t = my_date.createRamdomDate();
            date_array[i] = t;
        }
        for(int i=0; i<date_array.length;i++){
            System.out.println(date_array[i]);
        }

        for(int i=0; i<date_array.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<date_array.length;j++){
                String stringI = toString(date_array[minIndex],"HHmmss");
                String stringJ = toString(date_array[j],"HHmmss");

                int timeI = Integer.parseInt(stringI);
                int timeJ = Integer.parseInt(stringJ);

                if(timeJ<timeI){
                    minIndex = j;
                }
            }
            Date temp = date_array[minIndex];
            date_array[minIndex] = date_array[i];
            date_array[i] = temp;
        }

        System.out.println("排序后：\n");

        for(int i=0; i<date_array.length;i++){
            System.out.println(date_array[i]);
        }

    }
}
