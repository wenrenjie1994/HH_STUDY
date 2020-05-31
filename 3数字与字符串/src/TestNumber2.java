public class TestNumber2 {
    public static void main(String[] args)
    {
        int i=10;
        //将基本类型int转换为interger
        Integer it=new Integer(i);
        //把一个Integer对象，转换为一个基本类型的int
        int i2 = it.intValue();
        System.out.println(i2);
    }
}
