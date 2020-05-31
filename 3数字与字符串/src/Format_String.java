public class Format_String {
    public static void main(String[] args)
    {
        String name="xiaolan";
        int age=18;
        String address="China";

        String Content_Format="%s今年%d岁，在%s";

        //使用format格式化输出
        System.out.format(Content_Format,name,age,address);

    }
}
