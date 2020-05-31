//封装类
public class TestNumber {
    public static void main(String[] args)
    {
        int i=10;
        //将基本类型int转换为interger
        Integer it=new Integer(i);
        //把一个Integer对象，转换为一个基本类型的int
        int i2 = it.intValue();
        System.out.println(i2);

        //Integer是Number的子类，所以打印true
        System.out.println(it instanceof Number);//True

        //int的最大值
        System.out.println(Integer.MAX_VALUE);
        //int的最小值
        System.out.println(Integer.MIN_VALUE);
    }
}
