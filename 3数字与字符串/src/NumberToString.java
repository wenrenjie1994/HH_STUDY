public class NumberToString {
    public static void main(String[] args)
    {
        int i=10;
        //方法1  使用String类的静态方法valueOf
        String str=String.valueOf(i);

        //方法2  先把基本类型装箱为对象，然后调用对象的toString
        Integer it =i;
        String str2=it.toString();
    }
}
