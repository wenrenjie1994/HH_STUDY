import java.util.Date;

//1970
public class Data_Test {

    public static void main(String[] args) {
        // 当前时间
        Date d1 = new Date();
        System.out.println("当前时间:");
        System.out.println(d1);
        System.out.println();
        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2);//Thu Jan 01 08:00:05 CST 1970
    }
}