
/**
 * @author MartinVon
 * @create 2020-06-25-17:19
 * 测试常量自动转型
 */
public class Test1 {

    public static void main(String[] args) {

        final short b1 = 1;
        final short b2 = 2;

        short c1 = 1;
        short c2 = 2;

        byte a1 = b1 + b2;
//        byte a2 = c1 + c2;

        short a3 = b1 + b2;
//        short a4 = c1 + c2;

        int a5 = b1 + b2;
        int a6 = c1 + c2;


//        System.out.println(getType(a));
    }

    public static String getType(Object o) {

        return o.getClass().toString();
    }
}
