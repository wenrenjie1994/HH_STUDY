package day07.demo;

/*

==是进行字符串的地址值比较
若要使用字符串内容比较，有以下两个方法
1.public boolean equals(Object obj)
参数可以是任何对象，只有桉树是一个字符串并且内容相同时才会返回ture，否则返回false
2.public booliean equalsIngnoreCase(String str)
忽略大小写比较字符串内容，只有忽略英文字母的大小写
注：
1.任何对象都可以使用Object进行接收
2.equals方法具有对称性，即a.equals(b) 与b.equals(a)效果一样
3.如果比较上方一个常量一个变量推荐把常量字符串写在前面"abc".equals(str1)
 */
public class Demo3StringEquals {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        String str3 = new String(array);

        System.out.println(str1.equals(str2));//ture
        System.out.println(str1.equals(str3));//ture
        System.out.println(str2.equals("hello"));//ture
        System.out.println("hello".equals(str1));//true
        System.out.println(str1.equals("Hello"));//false
        System.out.println("==================================");

        String str5 = null;
        //推荐写法
        System.out.println("abc".equals(str5));//false
        //不推荐写法
        //System.out.println(str5.equals("abc"));//报错，空指针异常NullPointerException
        System.out.println("==================================");
        System.out.println("java".equalsIgnoreCase("jAVA"));//ture
    }

}
