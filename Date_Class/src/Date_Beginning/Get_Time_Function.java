/**
 * @Author lee
 * @Date 2020/6/7 10:39 AM
 * getTime()
 * 得到一个Long整型的整数
 * 每经历1毫秒增加1
 **/
import java.util.Date;

public class Get_Time_Function {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("当前时间："+now); // toString函数
        System.out.println("当前时间："+now.toString()); // toString函数

        System.out.println("当前时间getTime()函数得到的返回值是："+now.getTime());

        Date zero = new Date(0);
        System.out.println("用0作为构造函数的参数得到的时间为："+ zero);
    }
}
